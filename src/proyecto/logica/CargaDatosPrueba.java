package proyecto.logica;

import ConexionBBDD.ConexionBBDD;
import proyecto.modelo.*;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Lógica de negocio para cargar datos de prueba desde un fichero XML o JSON.
 */
public class CargaDatosPrueba {

    private ConexionBBDD cnx;
    
    // Mapas para almacenar la correspondencia entre índices del XML y IDs reales de BD
    private List<Integer> idsSociosReales = new ArrayList<>();
    private List<Integer> idsPlanesReales = new ArrayList<>();

    public String cargar(File fichero) throws Exception {

        // 1. Parsear segun extension
        String nombre = fichero.getName().toLowerCase();
        Map<String, List<?>> datos;

        if (nombre.endsWith(".xml")) {
            datos = new XmlParser().parsear(fichero);
        } else if (nombre.endsWith(".json")) {
            datos = new JsonParser().parsear(fichero);
        } else {
            throw new Exception("Formato no soportado. Usa ficheros .xml o .json");
        }

        // 2. Abrir conexion
        cnx = new ConexionBBDD();
        
        // Desactivar autocommit para poder hacer rollback si algo falla
        cnx.getConnection().setAutoCommit(false);

        StringBuilder sb = new StringBuilder();

        try {
            // 3. Insertar en orden respetando claves ajenas
            @SuppressWarnings("unchecked")
            List<Socio> socios = (List<Socio>) datos.get("socios");
            sb.append("Socios insertados      : ").append(insertarSocios(socios)).append("\n");

            @SuppressWarnings("unchecked")
            List<Plan> planes = (List<Plan>) datos.get("planes");
            sb.append("Planes insertados      : ").append(insertarPlanes(planes)).append("\n");

            @SuppressWarnings("unchecked")
            List<Pago> pagos = (List<Pago>) datos.get("pagos");
            sb.append("Pagos insertados       : ").append(insertarPagos(pagos)).append("\n");

            @SuppressWarnings("unchecked")
            List<Asistencia> asistencias = (List<Asistencia>) datos.get("asistencias");
            sb.append("Asistencias insertadas : ").append(insertarAsistencias(asistencias)).append("\n");

            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = (List<Usuario>) datos.get("usuarios");
            sb.append("Usuarios insertados    : ").append(insertarUsuarios(usuarios)).append("\n");

            // Confirmar todas las inserciones
            cnx.getConnection().commit();
            sb.append("\n CARGA COMPLETADA CON ÉXITO");

        } catch (Exception e) {
            // Si algo falla, deshacer todos los cambios
            cnx.getConnection().rollback();
            throw new Exception("Error durante la carga. Se ha realizado rollback.\n" + e.getMessage(), e);
        } finally {
            cnx.cerrar();
        }

        return sb.toString();
    }

    // ------------------------------------------------------------------
    //  INSERT con captura de IDs generados automáticamente              
    // ------------------------------------------------------------------

    private int insertarSocios(List<Socio> lista) throws Exception {
        int total = 0;
        String sql = "INSERT INTO socio (Nombre, Apellido1, Apellido2, DNI, " +
                     "Telefono, Correo, Fecha_Alta, Estado) VALUES (?,?,?,?,?,?,?,?)";
        
        for (Socio s : lista) {
            PreparedStatement ps = cnx.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, s.getNombre());
            ps.setString(2, s.getApellido1());
            ps.setString(3, s.getApellido2());
            ps.setString(4, s.getDni());
            ps.setString(5, s.getTelefono());
            ps.setString(6, s.getCorreo());
            ps.setDate  (7, new java.sql.Date(s.getFecha_alta().getTime()));
            ps.setString(8, s.getEstado());
            
            int afectadas = cnx.ejecutaSQL(ps);
            if (afectadas > 0) {
                total++;
                // Capturar el ID generado automáticamente
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idsSociosReales.add(rs.getInt(1));
                }
            }
        }
        return total;
    }

    private int insertarPlanes(List<Plan> lista) throws Exception {
        int total = 0;
        String sql = "INSERT INTO plan (Socio_ID, Descripcion, Importe, Fecha_Inicio, Fecha_Fin) VALUES (?,?,?,?,?)";

        for (int i = 0; i < lista.size(); i++) {
            Plan p = lista.get(i);
            PreparedStatement ps = cnx.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if (i < idsSociosReales.size()) {
                ps.setInt(1, idsSociosReales.get(i));
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
            }

            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getImporte());       // ← añadido
            ps.setDate  (4, new java.sql.Date(p.getFechaInicio().getTime()));
            ps.setDate  (5, new java.sql.Date(p.getFechaFin().getTime()));

            int afectadas = cnx.ejecutaSQL(ps);
            if (afectadas > 0) {
                total++;
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idsPlanesReales.add(rs.getInt(1));
                }
            }
        }
        return total;
    }

    private int insertarPagos(List<Pago> lista) throws Exception {
        int total = 0;
        String sql = "INSERT INTO pago (Socio_ID, Fecha_Pago, Importe, Estado) VALUES (?,?,?,?)";
        
        for (int i = 0; i < lista.size(); i++) {
            Pago p = lista.get(i);
            PreparedStatement ps = cnx.getConnection().prepareStatement(sql);
            
            // Usar el ID real del socio (por posición)
            if (i < idsSociosReales.size()) {
                ps.setInt(1, idsSociosReales.get(i));
            } else {
                ps.setInt(1, p.getSocio_id());
            }
            
            ps.setDate  (2, new java.sql.Date(p.getFecha_pago().getTime()));
            ps.setDouble(3, p.getImporte());
            ps.setString(4, p.getEstado());
            
            if (cnx.ejecutaSQL(ps) > 0) total++;
        }
        return total;
    }

    private int insertarAsistencias(List<Asistencia> lista) throws Exception {
        int total = 0;
        String sql = "INSERT INTO asistencia (Socio_ID, Fecha_Asistencia, Hora_entrada) VALUES (?,?,?)";
        
        for (int i = 0; i < lista.size(); i++) {
            Asistencia a = lista.get(i);
            PreparedStatement ps = cnx.getConnection().prepareStatement(sql);
            
            // Asignar socio por posición
            int socioIndex = i % idsSociosReales.size();
            if (socioIndex < idsSociosReales.size()) {
                ps.setInt(1, idsSociosReales.get(socioIndex));
            } else {
                ps.setInt(1, a.getId_socio());
            }
            
            ps.setDate(2, java.sql.Date.valueOf(a.getFecha()));
            ps.setTime(3, java.sql.Time.valueOf(a.getHora()));
            
            if (cnx.ejecutaSQL(ps) > 0) total++;
        }
        return total;
    }

    private int insertarUsuarios(List<Usuario> lista) throws Exception {
        int total = 0;
        String sql = "INSERT INTO usuario (Plan_ID, Usuario, Contrasena, Rol) VALUES (?,?,?,?)";
        
        for (int i = 0; i < lista.size(); i++) {
            Usuario u = lista.get(i);
            PreparedStatement ps = cnx.getConnection().prepareStatement(sql);
            
            // Usar el ID REAL del plan recién insertado
            if (i < idsPlanesReales.size()) {
                ps.setInt(1, idsPlanesReales.get(i));
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
            }
            
            ps.setString(2, u.getNombre_usuario());
            ps.setString(3, u.getContrasena());
            ps.setString(4, u.getRol());
            
            if (cnx.ejecutaSQL(ps) > 0) total++;
        }
        return total;
    }
}