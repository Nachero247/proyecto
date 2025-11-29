/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author DAM2Alu14
 */
public class Usuario {
    private int id_usuario;
    private int plan_id;
    private String nombre_usuario;
    private String contrasena;
    private String rol;

    // Constructor sin ID (para inserciones nuevas)
    public Usuario(int plan_id, String nombre_usuario, String contrasena, String rol) {
        this.plan_id = plan_id;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Constructor con todos los parámetros
    public Usuario(int id_usuario, int plan_id, String nombre_usuario, String contrasena, String rol) {
        this.id_usuario = id_usuario;
        this.plan_id = plan_id;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", plan_id=" + plan_id +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}