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
    private IncrementoMes nombre_mes;
    @OneToOne
    @JoinColumn(name = "incremento_trabajador")
    private IncrementoTrabajador incrementotrabajador;

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

    public IncrementoMes getNombre_mes() {
        return nombre_mes;
    }

    public void setNombre_mes(IncrementoMes nombre_mes) {
        this.nombre_mes = nombre_mes;
    }

    public IncrementoTrabajador getIncrementotrabajador() {
        return incrementotrabajador;
    }

    public void setIncrementotrabajador(IncrementoTrabajador incrementotrabajador) {
        this.incrementotrabajador = incrementotrabajador;
    }
}
