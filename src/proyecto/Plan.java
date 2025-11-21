/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.Date;

/**
 *
 * @author DAM2Alu9
 */
public class Plan {
    private int IdPlan;
    private int socioId;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;

    public Plan(int IdPlan, int socioId, String descripcion, Date fechaInicio, Date fechaFin) {
        this.IdPlan = IdPlan;
        this.socioId = socioId;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public int getIdPlan(){
        return IdPlan;
    }
    
    public void setIdPlan(int IdPlan){
        this.IdPlan = IdPlan;
    }

    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
}
