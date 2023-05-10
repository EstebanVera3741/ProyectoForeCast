package GlobantForeCast.Modelo.Entity.Forecast;

import jakarta.persistence.*;

@Entity
@Table(name = "demanda")
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroidentificacion")
    private Long numeroidentificacion;
    @Column(name = "cantidadtrabajador")
    private Integer cantidadtrabajador;
    @OneToOne
    @JoinColumn(name = "nombre_mes")
    private Mes nombre_mes;


    public Long getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public void setNumeroidentificacion(Long numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    public Integer getCantidadtrabajador() {
        return cantidadtrabajador;
    }

    public void setCantidadtrabajador(Integer cantidadtrabajador) {
        this.cantidadtrabajador = cantidadtrabajador;
    }

    public Mes getNombre_mes() {
        return nombre_mes;
    }

    public void setNombre_mes(Mes nombre_mes) {
        this.nombre_mes = nombre_mes;
    }
}
