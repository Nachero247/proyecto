/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.*;


/**
 *
 * @author DAM2Alu9
 */
public class Asistencia {
    private int id_asistencia;
    private int socio_id;
    private Date fecha;
    private Date hora;

    public Asistencia(int id_asistencia, int socio_id, Date fecha, Date hora) {
        this.id_asistencia = id_asistencia;
        this.socio_id = socio_id;
        this.fecha = fecha;
        this.hora = hora;
    }

    
    // getters y setters

    public int getId() {
        return id_asistencia;
    }

    public void setId(int id) {
        this.id_asistencia = id;
    }

    public int getId_socio() {
        return socio_id;
    }

    public void setId_socio(int id_socio) {
        this.socio_id = id_socio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
}

