package GlobantForeCast.Modelo.Repositorio;

import GlobantForeCast.Modelo.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {}