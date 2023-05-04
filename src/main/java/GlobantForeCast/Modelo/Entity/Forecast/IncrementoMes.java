package GlobantForeCast.Modelo.Entity.Forecast;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "incrementomes")
public class IncrementoMes {

    @Id
    @Column(name = "nombremes", length = 25)
    private String nombremes;

    public String getNombremes() {
        return nombremes;
    }

    public void setNombremes(String nombremes) {
        this.nombremes = nombremes;
    }
}
