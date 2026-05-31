package proyecto.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia {

    private int id_asistencia;
    private int socio_id;
    private LocalDate fecha;
    private LocalTime hora;

    public Asistencia(int id_asistencia, int socio_id, LocalDate fecha, LocalTime hora) {
        this.id_asistencia = id_asistencia;
        this.socio_id = socio_id;
        this.fecha = fecha;
        this.hora = hora;
    }

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}