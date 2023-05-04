package GlobantForeCast.Modelo.Entity.Forecast;

import GlobantForeCast.Modelo.Entity.Ciudad;
import jakarta.persistence.*;

@Entity
@Table(name = "incrementotrabajador")
public class IncrementoTrabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroidentificacion")
    private Integer numeroidentificacion;
    @Column(name = "cantidadtrabajador")
    private Integer cantidadtrabajador;
    @OneToOne
    @JoinColumn(name = "nombre_mes")
    private IncrementoMes nombre_mes;


    public Integer getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public void setNumeroidentificacion(Integer numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    public Integer getCantidadtrabajador() {
        return cantidadtrabajador;
    }

    public void setCantidadtrabajador(Integer cantidadtrabajador) {
        this.cantidadtrabajador = cantidadtrabajador;
    }

    public IncrementoMes getNombre_mes() {
        return nombre_mes;
    }

    public void setNombre_mes(IncrementoMes nombre_mes) {
        this.nombre_mes = nombre_mes;
    }
}
