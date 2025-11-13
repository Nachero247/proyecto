/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import ConexionBBDD.ConexionBBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        //String[] columnas ={"Nombre", "Apellido", "Provincia", "Edad", "Correo", "Alta"};
        // String nombre, String apellido1, String apellido2, String dni, String telefono, String correo, Date fecha_alta, String estado) {
        for (int i = 0; i < 30; i++) {
            Socio socio = new Socio("Nombre"+i, "Apellido"+i, "Apellido"+i  ,"18059864P" ,"677889966" , "mail"+i, new Date() , "Alta");
            listaSocios.add(socio);
        }
        
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
