package GlobantForeCast.Modelo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "generacion")
public class Generacion {

    @Id
    @Column(name = "nombregeneracion", length = 25)
    private String nombreGeneracion;
    @Column(name = "fechail")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIL;
    @Column(name = "fechafp")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFP;
    @ManyToOne
    @JoinColumn(name = "nombre_ciudad")
    private Ciudad nombre_Ciudad;
    @OneToMany(mappedBy = "nombre_Generacion")
    private List<Estudiante> listaEstudiantes;

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public String getNombreGeneracion() {
        return nombreGeneracion;
    }

    public void setNombreGeneracion(String nombreGeneracion) {
        this.nombreGeneracion = nombreGeneracion;
    }

    public Ciudad getNombre_Ciudad() {
        return nombre_Ciudad;
    }

    public void setNombre_Ciudad(Ciudad nombre_Ciudad) {
        this.nombre_Ciudad = nombre_Ciudad;
    }

    public LocalDate getFechaIL() {
        return fechaIL;
    }

    public void setFechaIL(LocalDate fechaIL) {
        this.fechaIL = fechaIL;
    }

    public LocalDate getFechaFP() {
        return fechaFP;
    }

    public void setFechaFP(LocalDate fechaFP) {
        this.fechaFP = fechaFP;
    }
}