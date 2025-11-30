/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DAM2Alu14
 */
public class Socio {
    static int contadorId = 0;
    
    int id_socio;
    String nombre;
    String apellido1;
    String apellido2;
    String dni;
    String telefono;
    String correo;
    Date fecha_alta;
    String estado;
    
    // CONSTRUCTOR VACIO
    public Socio(){
        id_socio=contadorId;
        contadorId++;
    }
    
    // CONSTRUCTOR LLENO
    public Socio(String nombre, String apellido1, String apellido2, String dni, String telefono, String correo, Date fecha_alta, String estado) {
                id_socio=contadorId++;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha_alta = fecha_alta;
                this.estado = estado;
	}
	
    
    // GETTER AND SETTER
    public int getContadorId() {
            return contadorId;
    }
    public void setContadorId(int contadorId) {
            this.contadorId = contadorId;
    }
    public int getId_socio() {
            return id_socio;
    }
    public void setId_socio(int id_socio) {
            this.id_socio = id_socio;
    }
    public String getNombre() {
            return nombre;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
    public String getApellido1() {
            return apellido1;
    }
    public void setApellido1(String apellido1) {
            this.apellido1 = apellido1;
    }
    public String getApellido2() {
            return apellido2;
    }
    public void setApellido2(String apellido2) {
            this.apellido2 = apellido2;
    }
    public String getDni() {
            return dni;
    }
    public void setDni(String dni) {
            this.dni = dni;
    }
    public String getTelefono() {
            return telefono;
    }
    public void setTelefono(String telefono) {
            this.telefono = telefono;
    }
    public String getCorreo() {
            return correo;
    }
    public void setCorreo(String correo) {
            this.correo = correo;
    }
    public Date getFecha_alta() {
            return fecha_alta;
    }
    public void setFecha_alta(Date fecha_alta) {
            this.fecha_alta = fecha_alta;
    }
    public String getEstado() {
            return estado;
    }
    public void setEstado(String estado) {
            estado = estado;
    }

    // TO STRING
    @Override
    public String toString() {
            return "Socio [contadorId=" + contadorId + ", id_socio=" + id_socio + ", nombre=" + nombre + ", apellido1="
                            + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni + ", telefono=" + telefono + ", correo="
                            + correo + ", fecha_alta=" + fecha_alta + ", estado=" + estado + "]";
    }
    
    // OTROS METODOS
    public static String[] getColumnas() {
        String[] columnas ={"ID", "Nombre", "Apellido1", "Apellido2",  "DNI", "Telefono" , "Correo", "Fecha de Alta", "Estado"};
        return columnas;
    }
    
    public String[] devuelveFila() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy, hh:mm");
        String[] fila={
            String.valueOf(id_socio),
            nombre,
            apellido1, 
            apellido2, 
            dni, 
            telefono,
            correo,
            sdf.format(fecha_alta),
            estado
        };
        return fila;
    }
}
