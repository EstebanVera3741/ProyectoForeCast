package GlobantForeCast.Query.CRUD.Visualizar;

import GlobantForeCast.Modelo.Entity.Estudiante;
import GlobantForeCast.Modelo.Entity.Trabajador;
import GlobantForeCast.Modelo.Repositorio.TrabajadorRepository;
import GlobantForeCast.Query.Service.VisualizarService.VisualizarTrabajadorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisualizarTrabajador implements VisualizarTrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Trabajador> consultarTrabajadores() {
        return this.trabajadorRepository.findAll();
    }

    @Override
    public Trabajador consultarTrabajador(String identificacion) {
        return trabajadorRepository.findById(identificacion).get();
    }

    @Override
    public Long contarTrabajadores() {
        return trabajadorRepository.count();
    }

    @Override
    public List<Trabajador> cantidadTrabajadoresPorMes(int numeroMes) {
        TypedQuery<Trabajador> query = entityManager.createQuery(
                "SELECT t FROM Trabajador t WHERE extract(MONTH FROM CAST(t.fechaIngreso AS date)) = :numeroMes",
                Trabajador.class);
        query.setParameter("numeroMes", numeroMes);
        return query.getResultList();
    }
}