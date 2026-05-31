package proyecto.logica;

import proyecto.modelo.Plan;
import ConexionBBDD.ConexionBBDD;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO {
    
    ConexionBBDD nueva = new ConexionBBDD();
    Connection con;
    
    public PlanDAO(){
        con = nueva.getConnection();
    }
    
    public List<Plan> listar(){
        List<Plan> lista = new ArrayList<>();
        String sql = "SELECT * FROM plan";
        try(PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Plan p = new Plan(
                    rs.getInt("id_plan"),
                    rs.getInt("Socio_ID"),
                    rs.getString("Descripcion"),
                    rs.getDouble("Importe"),
                    rs.getDate("Fecha_Inicio"),
                    rs.getDate("Fecha_Fin")
                );
                lista.add(p);
            }
        }catch(SQLException e){ e.printStackTrace(); }
        return lista;
    }
    
    public boolean insertar(Plan p){
        String sql = "INSERT INTO plan(Socio_ID, Descripcion, Importe, Fecha_Inicio, Fecha_Fin) VALUES (?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            if (p.getSocioId() == 0) {
                ps.setNull(1, Types.INTEGER);
            } else {
                ps.setInt(1, p.getSocioId());
            }
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getImporte());
            ps.setDate(4, new java.sql.Date(p.getFechaInicio().getTime()));
            ps.setDate(5, new java.sql.Date(p.getFechaFin().getTime()));
            return ps.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizar(Plan p){
        String sql = "UPDATE plan SET Socio_ID=?, Descripcion=?, Importe=?, Fecha_Inicio=?, Fecha_Fin=? WHERE id_plan=?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, p.getSocioId());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getImporte());
            ps.setDate(4, new java.sql.Date(p.getFechaInicio().getTime()));
            ps.setDate(5, new java.sql.Date(p.getFechaFin().getTime()));
            ps.setInt(6, p.getIdPlan());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminar(int idPlan){
        String sql = "DELETE FROM plan WHERE id_plan = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idPlan);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public Plan buscar(int idPlan){
        String sql = "SELECT * FROM plan WHERE id_plan = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, idPlan);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Plan(
                    rs.getInt("id_plan"),
                    rs.getInt("Socio_ID"),
                    rs.getString("Descripcion"),
                    rs.getDouble("Importe"),
                    rs.getDate("Fecha_Inicio"),
                    rs.getDate("Fecha_Fin")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}