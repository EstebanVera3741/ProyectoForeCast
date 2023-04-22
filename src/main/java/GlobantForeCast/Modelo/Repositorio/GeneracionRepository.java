package GlobantForeCast.Modelo.Repositorio;

import GlobantForeCast.Modelo.Entity.Generacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneracionRepository extends JpaRepository<Generacion, String> {}