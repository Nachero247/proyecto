package proyecto.logica;

import proyecto.modelo.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class JsonParser {

    private static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm:ss");

    public Map<String, List<?>> parsear(File fichero) throws Exception {
        String contenido = new String(Files.readAllBytes(fichero.toPath()), StandardCharsets.UTF_8);
        JSONObject root = new JSONObject(contenido);

        Map<String, List<?>> resultado = new LinkedHashMap<>();
        resultado.put("socios",      parseSocios(root));
        resultado.put("planes",      parsePlanes(root));
        resultado.put("pagos",       parsePagos(root));
        resultado.put("asistencias", parseAsistencias(root));
        resultado.put("usuarios",    parseUsuarios(root));
        return resultado;
    }

    //  Socios (campos en minúscula)
    private List<Socio> parseSocios(JSONObject root) throws Exception {
        List<Socio> lista = new ArrayList<>();
        if (!root.has("socios")) return lista;
        JSONArray arr = root.getJSONArray("socios");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Socio s = new Socio(
                str(o, "nombre"),
                str(o, "apellido1"),
                str(o, "apellido2"),
                str(o, "dni"),
                str(o, "telefono"),
                str(o, "correo"),
                parseFecha(str(o, "fecha_alta")),
                str(o, "estado")
            );
            lista.add(s);
        }
        return lista;
    }

    // Planes (sin Socio_ID, se asignará después)
    private List<Plan> parsePlanes(JSONObject root) throws Exception {
        List<Plan> lista = new ArrayList<>();
        if (!root.has("planes")) return lista;
        JSONArray arr = root.getJSONArray("planes");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Plan p = new Plan(
                0,
                o.has("socio_id") ? o.getInt("socio_id") : 0,  // ← lee socio_id
                str(o, "descripcion"),
                o.has("importe") ? o.getDouble("importe") : 0.0,
                parseFecha(str(o, "fecha_inicio")),
                parseFecha(str(o, "fecha_fin"))
            );
            lista.add(p);
        }
        return lista;
    }

    //  Pagos (sin Socio_ID, se asignará después)
    private List<Pago> parsePagos(JSONObject root) throws Exception {
        List<Pago> lista = new ArrayList<>();
        if (!root.has("pagos")) return lista;
        JSONArray arr = root.getJSONArray("pagos");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Pago p = new Pago(
                o.has("socio_id") ? o.getInt("socio_id") : 0,  // ← lee socio_id
                parseFecha(str(o, "fecha_pago")),
                o.getDouble("importe"),
                str(o, "estado")
            );
            lista.add(p);
        }
        return lista;
    }

    //  Asistencias (sin Socio_ID, se asignará después)
    private List<Asistencia> parseAsistencias(JSONObject root) throws Exception {
        List<Asistencia> lista = new ArrayList<>();
        if (!root.has("asistencias")) return lista;
        JSONArray arr = root.getJSONArray("asistencias");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Asistencia a = new Asistencia(
                0,
                o.has("socio_id") ? o.getInt("socio_id") : 0,  // ← lee socio_id
                LocalDate.parse(str(o, "fecha_asistencia")),
                parseHora(str(o, "hora_entrada"))
            );
            lista.add(a);
        }
        return lista;
    }

    private java.time.LocalTime parseHora(String horaStr) {
        if (horaStr == null || horaStr.trim().isEmpty()) {
            return java.time.LocalTime.of(0, 0, 0);
        }
        return java.time.LocalTime.parse(horaStr);
    }

    // Usuarios (sin Plan_ID, se asignará después)
    private List<Usuario> parseUsuarios(JSONObject root) {
        List<Usuario> lista = new ArrayList<>();
        if (!root.has("usuarios")) return lista;
        JSONArray arr = root.getJSONArray("usuarios");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Usuario u = new Usuario(
                o.has("plan_id") ? o.getInt("plan_id") : 0,  // ← lee plan_id
                str(o, "usuario"),
                str(o, "contrasena"),
                str(o, "rol")
            );
            lista.add(u);
        }
        return lista;
    }

    // Utilidades de parseo con manejo de cadenas vacías 
    private Date parseFecha(String fechaStr) throws Exception {
        if (fechaStr == null || fechaStr.trim().isEmpty()) {
            // Si no hay fecha, usar la fecha actual (o lanzar excepción)
            return new Date();
        }
        return SDF_DATE.parse(fechaStr);
    }


    private String str(JSONObject o, String key) {
        return (o.has(key) && !o.isNull(key)) ? o.getString(key) : "";
    }
}