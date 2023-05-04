package GlobantForeCast.Forecast.Repositorio;

import GlobantForeCast.Modelo.Entity.Forecast.IncrementoTrabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncrementoTrabajadorRepository extends JpaRepository<IncrementoTrabajador, Long> {
}
