package proyecto.modelo;

import java.util.Date;

public class Plan {
    private int IdPlan;
    private int socioId;
    private String descripcion;
    private double importe;
    private Date fechaInicio;
    private Date fechaFin;

    public Plan(int IdPlan, int socioId, String descripcion, double importe, Date fechaInicio, Date fechaFin) {
        this.IdPlan = IdPlan;
        this.socioId = socioId;
        this.descripcion = descripcion;
        this.importe = importe;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdPlan() { return IdPlan; }
    public void setIdPlan(int IdPlan) { this.IdPlan = IdPlan; }

    public int getSocioId() { return socioId; }
    public void setSocioId(int socioId) { this.socioId = socioId; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getImporte() { return importe; }
    public void setImporte(double importe) { this.importe = importe; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
}