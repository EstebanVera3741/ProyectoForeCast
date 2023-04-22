package GlobantForeCast.Modelo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajador")
public class Trabajador {

    @Column(name = "nombrecompleto")
    private String nombrecompleto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroidentificacion")
    private Integer numeroidentificacion;

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