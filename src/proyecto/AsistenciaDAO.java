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
    
    public boolean registrarAsistencias(int idAsistencia,int idSocio){
        String sql = "INSERT INTO asistencia(idAsistencia, idSocio, Fecha_Asistencia, Hora_Entrada) VALUES (?,?,CURDATE(), CURTIME())";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAsistencia);
            ps.setInt(2, idSocio);
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
                Asistencia = new Asistencia(
                rs.getInt("Id"),
                rs.getInt("id_socio"),
                rs.getDate("fecha_asistencia"),
                rs.getTime(sql)
                );
                Lista.add(rs);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Lista;
    }
    
    
}

