package GlobantForeCast.Modelo.Repositorio;

import GlobantForeCast.Modelo.Entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, String> {}