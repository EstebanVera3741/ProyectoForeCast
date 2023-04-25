package GlobantForeCast.Query.CRUD.Visualizar;

import GlobantForeCast.Modelo.Entity.Estudiante;
import GlobantForeCast.Modelo.Entity.Generacion;
import GlobantForeCast.Modelo.Repositorio.EstudianteRepository;
import GlobantForeCast.Query.Service.VisualizarService.VisualizarEstudiantesService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisualizarEstudiante implements VisualizarEstudiantesService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estudiante> consultarEstudiantes() {
        return this.estudianteRepository.findAll();
    }

    @Override
    public Estudiante consultarEstudiante(String identificacion) {
        return this.estudianteRepository.findById(identificacion).get();
    }

    @Override
    public List<Estudiante> consultarEstudiantesPorGeneracion(Generacion nombreGeneracion) {
        TypedQuery<Estudiante> query = entityManager.createQuery(
                "SELECT e FROM Estudiante e WHERE e.nombre_Generacion = :nombreGeneracion",
                Estudiante.class);
        query.setParameter("nombreGeneracion", nombreGeneracion);
        return query.getResultList();
    }
}