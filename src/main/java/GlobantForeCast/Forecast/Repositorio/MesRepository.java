package GlobantForeCast.Forecast.Repositorio;

import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesRepository extends JpaRepository<Mes, String> {
}
