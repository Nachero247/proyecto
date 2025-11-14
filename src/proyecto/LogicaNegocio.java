/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import ConexionBBDD.ConexionBBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DAM2Alu14
 */
public class LogicaNegocio {
    static List<Socio> listaSocios = new ArrayList(); 
  
    public static void cargaPrueba() {
        /*
        listaSocios.clear();  // Limpiamos lista antes de cargar

        String sql = "SELECT id_socio, nombre, apellido1, apellido2, dni, telefono, correo, fecha_alta, estado "
                   + "FROM socios";

        try (Connection con = ConexionBBDD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Socio socio = new Socio(
                        rs.getInt("id_socio"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getDate("fecha_alta"),
                        rs.getString("estado")
                );

                listaSocios.add(socio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Error cargando socios desde la BBDD");
        }
        */
    }
    
    
    public static void addSocio (Socio socio) {
        listaSocios.add(socio);
    }
    
    public static void removeSocio(Socio socio) {
        listaSocios.remove(socio);
    }
    
    public static void removeSocio(int id){
        for (Socio socio : listaSocios) {
            if(socio.getId_socio()==id) {
                listaSocios.remove(socio);
            }
        }
    }
    
    public static Socio getSocio(int id) {
        for (Socio socio : listaSocios) {
            if (socio.getId_socio() ==id) {
                return socio;
            }
        }
        return null;
    }
    
    public static void editSocio(Socio editar){
        for (int i = 0; i< listaSocios.size(); i++) {
            if (listaSocios.get(i).getId_socio() == editar.getId_socio())
                   listaSocios.set(i, editar);
    
        }
        
    }
    
    public static List<Socio> getSocios() {
        return listaSocios;
    }
 
}
