/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import ConexionBBDD.ConexionBBDD;
import java.sql.Connection;
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
    
    
}

