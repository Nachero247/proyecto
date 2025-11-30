/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

import java.util.Date;

/**
 *
 * @author DAM2Alu14
 */
public class Pago {
    private int id_pago;
    private int socio_id;
    private Date fecha_pago;
    private double importe;
    private String estado;

    // Constructor sin ID (para inserciones nuevas)
    public Pago(int socio_id, Date fecha_pago, double importe, String estado) {
        this.socio_id = socio_id;
        this.fecha_pago = fecha_pago;
        this.importe = importe;
        this.estado = estado;
    }

    // Constructor con todos los parámetros
    public Pago(int id_pago, int socio_id, Date fecha_pago, double importe, String estado) {
        this.id_pago = id_pago;
        this.socio_id = socio_id;
        this.fecha_pago = fecha_pago;
        this.importe = importe;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getSocio_id() {
        return socio_id;
    }

    public void setSocio_id(int socio_id) {
        this.socio_id = socio_id;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id_pago=" + id_pago +
                ", socio_id=" + socio_id +
                ", fecha_pago=" + fecha_pago +
                ", importe=" + importe +
                ", estado='" + estado + '\'' +
                '}';
    }
}