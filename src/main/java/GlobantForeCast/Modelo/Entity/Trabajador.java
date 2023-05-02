package GlobantForeCast.Modelo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "trabajador")
public class Trabajador {

    @Column(name = "nombrecompleto")
    private String nombrecompleto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroidentificacion")
    private Integer numeroidentificacion;
    @Column(name = "fechaingreso")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaContratacion) {
        this.fechaIngreso = fechaContratacion;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public Integer getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public void setNumeroidentificacion(Integer numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }
}