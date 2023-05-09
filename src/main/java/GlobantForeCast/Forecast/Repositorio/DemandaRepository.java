package GlobantForeCast.Forecast.Repositorio;

import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandaRepository extends JpaRepository<Demanda, Long> {
}
