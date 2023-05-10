package GlobantForeCast.Forecast.CRUD.Visualizar;

import GlobantForeCast.Forecast.Repositorio.PronosticoRepository;
import GlobantForeCast.Forecast.Service.VisualizarService.VisualizarPronosticoService;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Forecast.Pronostico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizarPronostico implements VisualizarPronosticoService {

    @Autowired
    private PronosticoRepository pronosticoRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Demanda> consultarPronosticoPorMes(int numeroMes) {
        TypedQuery<Demanda> query = entityManager.createQuery(
                "SELECT e.cantidadtrabajador FROM Demanda e WHERE e.numeroidentificacion = :numero",
                Demanda.class);
        query.setParameter("numero", numeroMes);

        return query.getResultList();
    }
}
