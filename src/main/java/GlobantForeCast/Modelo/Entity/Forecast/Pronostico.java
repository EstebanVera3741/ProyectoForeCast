package GlobantForeCast.Modelo.Entity.Forecast;

import jakarta.persistence.*;

@Entity
@Table (name = "pronostico")
public class Pronostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroidentificacion")
    private Integer numeroidentificacion;

    @Column(name = "cantidadpronostico")
    private Integer cantidadpronostico;

    @OneToOne
    @JoinColumn(name = "nombre_mes")
    private Mes nombre_mes;
    @OneToOne
    @JoinColumn(name = "identificacion_trabajador")
    private Demanda identificaciontrabajador;

    public Integer getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public void setNumeroidentificacion(Integer numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    public Integer getCantidadpronostico() {
        return cantidadpronostico;
    }

    public void setCantidadpronostico(Integer cantidadpronostico) {
        this.cantidadpronostico = cantidadpronostico;
    }

    public Mes getNombre_mes() {
        return nombre_mes;
    }

    public void setNombre_mes(Mes nombre_mes) {
        this.nombre_mes = nombre_mes;
    }

    public Demanda getIdentificaciontrabajador() {
        return identificaciontrabajador;
    }

    public void setIdentificaciontrabajador(Demanda incrementotrabajador) {
        this.identificaciontrabajador = incrementotrabajador;
    }
}
