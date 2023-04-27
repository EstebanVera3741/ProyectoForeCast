package GlobantForeCast.Modelo.Entity.Enlace;

import java.time.LocalDate;

public class EnlaceTrabajador {

    private Long numeroTrabajadores;
    private LocalDate fechaFC;

    public Long getNumeroTrabajadores() {
        return numeroTrabajadores;
    }

    public void setNumeroTrabajadores(Long numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }

    public LocalDate getFechaFC() {
        return fechaFC;
    }

    public void setFechaFC(LocalDate fechaFC) {
        this.fechaFC = fechaFC;
    }
}