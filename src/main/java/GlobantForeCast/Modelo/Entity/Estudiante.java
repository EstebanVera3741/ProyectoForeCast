package GlobantForeCast.Modelo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Column(name = "nombrecompleto")
    private String nombreCompleto;
    @Id
    @Column(name = "numeroidentificacion", length = 25)
    private String numeroIdentificacion;
    @Column(name = "correoelectronico")
    private String correoElectronico;
    @ManyToOne
    @JoinColumn(name = "nombre_generacion")
    private Generacion nombre_Generacion;
    @ManyToOne
    @JoinColumn(name = "nombre_institucion")
    private Institucion nombre_Institucion;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Generacion getNombre_Generacion() {
        return nombre_Generacion;
    }

    public void setNombre_Generacion(Generacion nombre_Generacion) {
        this.nombre_Generacion = nombre_Generacion;
    }

    public Institucion getNombre_Institucion() {
        return nombre_Institucion;
    }

    public void setNombre_Institucion(Institucion nombre_Institucion) {
        this.nombre_Institucion = nombre_Institucion;
    }
}