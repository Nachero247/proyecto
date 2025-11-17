/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import ConexionBBDD.ConexionBBDD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DAM2Alu9
 */
public class AsistenciaDAO {
    
    ConexionBBDD nueva = new ConexionBBDD();
    Connection con;
    
    public AsistenciaDAO(){
        con = nueva.getConnection();
    }
    
    public boolean registrarAsistencias(int idSocio){
        String sql = "INSERT INTO asistencia(socio_id, Fecha_Asistencia, Hora_Entrada) VALUES (?,CURDATE(), NOW())";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ps.executeUpdate();
            return true;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List <Asistencia> ListarAsistencia(){
        List<Asistencia> Lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencia";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Asistencia a = new Asistencia(
                rs.getInt("id_asistencia"),
                rs.getInt("socio_id"),
                rs.getDate("fecha_asistencia"),
                rs.getDate("hora_entrada")
                );
                Lista.add(a);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Lista;
    }
    
    
}

