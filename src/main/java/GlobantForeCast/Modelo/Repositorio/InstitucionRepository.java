package GlobantForeCast.Modelo.Repositorio;

import GlobantForeCast.Modelo.Entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, String> {}