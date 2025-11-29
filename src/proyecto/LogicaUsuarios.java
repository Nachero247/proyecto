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
import java.util.Iterator;
import java.util.List;

/**
 * @author DAM2Alu14
 */
public class LogicaUsuarios {
    static List<Usuario> listaUsuarios = new ArrayList();

    public static void cargaPrueba() {
        listaUsuarios.clear();  // Limpiamos lista antes de cargar
        
        String sql = "SELECT ID_Usuario, Plan_ID, Usuario, Contrasena, Rol "
                   + "FROM usuario";
        try {
            ConexionBBDD nueva = new ConexionBBDD();
            Connection conexion = nueva.getConnection();
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int plan_id = rs.getInt("Plan_ID");
                Usuario usuario = new Usuario(
                    plan_id,
                    rs.getString("Usuario"),
                    rs.getString("Contrasena"),
                    rs.getString("Rol")
                );
                usuario.setId_usuario(rs.getInt("ID_Usuario"));
                listaUsuarios.add(usuario);
            }
            rs.close();
            ps.close();
            conexion.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error cargando usuarios desde la BBDD");
        }
    }

    public static void addUsuario(Usuario usuario) {
        System.out.println("Agregando usuario con ID: " + usuario.getId_usuario());
        listaUsuarios.add(usuario);
    }

    public static void removeUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    public static void removeUsuario(int id) {
        // Usar Iterator para evitar ConcurrentModificationException
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getId_usuario() == id) {
                iterator.remove();
                System.out.println("Usuario con ID " + id + " eliminado");
                break;
            }
        }
    }

    public static Usuario getUsuario(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId_usuario() == id) {
                return usuario;
            }
        }
        return null;
    }

    public static void editUsuario(Usuario editar) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId_usuario() == editar.getId_usuario()) {
                listaUsuarios.set(i, editar);  // Se reemplaza el usuario en la lista
                System.out.println("Usuario con ID " + editar.getId_usuario() + " actualizado");
            }
        }
    }

    public static List<Usuario> getUsuarios() {
        return listaUsuarios;
    }
}