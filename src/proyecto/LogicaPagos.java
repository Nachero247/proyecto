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
public class LogicaPagos {
    static List<Pago> listaPagos = new ArrayList();

    public static void cargaPrueba() {
        listaPagos.clear();  // Limpiamos lista antes de cargar
        
        String sql = "SELECT ID_Pago, Socio_ID, Fecha_Pago, Importe, Estado "
                   + "FROM pago";
        try {
            ConexionBBDD nueva = new ConexionBBDD();
            Connection conexion = nueva.getConnection();
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pago pago = new Pago(
                    rs.getInt("Socio_ID"),
                    rs.getDate("Fecha_Pago"),
                    rs.getDouble("Importe"),
                    rs.getString("Estado")
                );
                pago.setId_pago(rs.getInt("ID_Pago"));
                listaPagos.add(pago);
            }
            rs.close();
            ps.close();
            conexion.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error cargando pagos desde la BBDD");
        }
    }

    public static void addPago(Pago pago) {
        System.out.println("Agregando pago con ID: " + pago.getId_pago());
        listaPagos.add(pago);
    }

    public static void removePago(Pago pago) {
        listaPagos.remove(pago);
    }

    public static void removePago(int id) {
        Iterator<Pago> iterator = listaPagos.iterator();
        while (iterator.hasNext()) {
            Pago pago = iterator.next();
            if (pago.getId_pago() == id) {
                iterator.remove();
                System.out.println("Pago con ID " + id + " eliminado");
                break;
            }
        }
    }

    public static Pago getPago(int id) {
        for (Pago pago : listaPagos) {
            if (pago.getId_pago() == id) {
                return pago;
            }
        }
        return null;
    }

    public static void editPago(Pago editar) {
        for (int i = 0; i < listaPagos.size(); i++) {
            if (listaPagos.get(i).getId_pago() == editar.getId_pago()) {
                listaPagos.set(i, editar);  // Se reemplaza el pago en la lista
                System.out.println("Pago con ID " + editar.getId_pago() + " actualizado");
            }
        }
    }

    public static List<Pago> getPagos() {
        return listaPagos;
    }

    // Obtiene pagos pendientes
    public static List<Pago> getPagosPendientes() {
        List<Pago> pagosPendientes = new ArrayList();
        for (Pago pago : listaPagos) {
            if (pago.getEstado().equals("Pendiente")) {
                pagosPendientes.add(pago);
            }
        }
        return pagosPendientes;
    }
}