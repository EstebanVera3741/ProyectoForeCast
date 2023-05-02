package GlobantForeCast.Modelo.Entity.Enlace;

import java.time.LocalDate;

public class EnlaceTrabajador {

    private Integer numeroTrabajadores;
    private LocalDate fechaIngreso;

    public Integer getNumeroTrabajadores() {
        return numeroTrabajadores;
    }

    public void setNumeroTrabajadores(Integer numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}