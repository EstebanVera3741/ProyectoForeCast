package GlobantForeCast.Forecast.Repositorio;

import GlobantForeCast.Modelo.Entity.Forecast.IncrementoMes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncrementoMesRepository extends JpaRepository<IncrementoMes, String> {
}
