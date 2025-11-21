/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import ConexionBBDD.ConexionBBDD;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM2Alu9
 */
public class PlanDAO {
    
    ConexionBBDD nueva = new ConexionBBDD();
    Connection con;
    
    public PlanDAO(){
        con = nueva.getConnection();
    }
    
    public List<Plan> listar(){
        List<Plan> lista = new ArrayList<>();
        String sql = "SELECT * FROM plan";
        
        try(PreparedStatement ps =  con.prepareStatement(sql);
               ResultSet rs = ps.executeQuery() ){
            
            while(rs.next()){
                Plan p = new Plan(
                rs.getInt("id_plan"),
                rs.getInt("Socio_ID"),
                rs.getString("Descripcion"),
                rs.getDate("Fecha_Inicio"),
                rs.getDate("Fecha_Fin")
                );
                lista.add(p);
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    
    public boolean insertar(Plan p){
        String sql = "INSERT INTO plan(Socio_ID, Descripcion, Fecha_Inicio, Fecha_Fin) VALUES (?,?,?,?)";
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, p.getSocioId());
            ps.setString(2, p.getDescripcion());
            ps.setDate(3, new java.sql.Date(p.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(p.getFechaFin().getTime()));
            
            return ps.executeUpdate()>0;
            
                           
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizar(Plan p){
        String sql = "UPDATE pla SET Socio_ID = ?, Descripcion = ?, Fecha_Inicio = ?, Fecha_Fin = ? WHERE id_Plan = ?";
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, p.getSocioId());
            ps.setString(2, p.getDescripcion());
            ps.setDate(3, new java.sql.Date(p.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(p.getFechaFin().getTime()));
            ps.setInt(5, p.getIdPlan());
            
            return ps.executeUpdate()>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
