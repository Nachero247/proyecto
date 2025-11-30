/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.logica;

import proyecto.modelo.Socio;
import ConexionBBDD.ConexionBBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author DAM2Alu14
 */
public class LogicaSocios {
    static List<Socio> listaSocios = new ArrayList(); 
  
    public static void cargaPrueba() {
        
        listaSocios.clear();  // Limpiamos lista antes de cargar
        
        String sql = "SELECT id_socio, nombre, apellido1, apellido2, dni, telefono, correo, fecha_alta, estado "
                   + "FROM socio";

        try {
            ConexionBBDD nueva = new ConexionBBDD();
            Connection conexion = nueva.getConnection();
        
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Socio socio = new Socio(
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("dni"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getDate("fecha_alta"),
                    rs.getString("estado")
                );

                socio.setId_socio(rs.getInt("id_socio"));

                listaSocios.add(socio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error cargando socios desde la BBDD");
        }
        
    }
    
    
    public static void addSocio (Socio socio) {
        System.out.println(socio.getId_socio());
        listaSocios.add(socio);
    }
    
    public static void removeSocio(Socio socio) {
        listaSocios.remove(socio);
    }
    
public static void removeSocio(int id){
    Iterator<Socio> iterator = listaSocios.iterator();
    while (iterator.hasNext()) {
        Socio socio = iterator.next();
        if(socio.getId_socio() == id) {
            iterator.remove();
            break; // Salir después de encontrar el socio
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
    
    public static void editSocio(Socio editar) {
        for (int i = 0; i < listaSocios.size(); i++) {
            if (listaSocios.get(i).getId_socio() == editar.getId_socio()) {
                listaSocios.set(i, editar);  // Se reemplaza el socio en la lista.
            }
        }
    }

    
    public static List<Socio> getSocios() {
        return listaSocios;
    }
 
}
