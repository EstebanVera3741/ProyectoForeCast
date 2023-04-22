package GlobantForeCast.Modelo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class Institucion {

    @Id
    @Column(name = "nombreinstitucion", length = 25)
    private String nombreInstitucion;
    @ManyToOne
    @JoinColumn(name = "nombre_ciudad")
    private Ciudad nombre_Ciudad;

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public Ciudad getNombre_Ciudad() {
        return nombre_Ciudad;
    }

    public void setNombre_Ciudad(Ciudad nombre_Ciudad) {
        this.nombre_Ciudad = nombre_Ciudad;
    }
}