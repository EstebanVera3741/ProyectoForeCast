package GlobantForeCast.Forecast.CRUD.Visualizar;

import GlobantForeCast.Forecast.Repositorio.IncrementoTrabajadorRepository;
import GlobantForeCast.Forecast.Service.VisualizarService.VisualizarIncrementoTrabajadorService;
import GlobantForeCast.Modelo.Entity.Estudiante;
import GlobantForeCast.Modelo.Entity.Forecast.IncrementoMes;
import GlobantForeCast.Modelo.Entity.Forecast.IncrementoTrabajador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisualizarIncrementoTrabajador implements VisualizarIncrementoTrabajadorService {
    @Autowired
    private IncrementoTrabajadorRepository incrementoTrabajadorRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public IncrementoTrabajador consultarIdIncrementoTrabajador(Integer cantidadTrabajadores) {

        TypedQuery<IncrementoTrabajador> query = entityManager.createQuery(
                "SELECT e FROM IncrementoTrabajador e WHERE e.cantidadtrabajador = :cantidadTrabajadores",
                IncrementoTrabajador.class);
        query.setParameter("cantidadTrabajadores", cantidadTrabajadores);

        return query.getSingleResult();
    }
}
