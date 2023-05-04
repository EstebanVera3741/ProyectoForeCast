package GlobantForeCast.Forecast.Repositorio;

import GlobantForeCast.Modelo.Entity.Forecast.Pronostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {
}
