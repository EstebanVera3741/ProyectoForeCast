package GlobantForeCast.Forecast.CRUD.Visualizar;

import GlobantForeCast.Forecast.Repositorio.DemandaRepository;
import GlobantForeCast.Forecast.Service.VisualizarService.VisualizarDemandaService;
import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizarDemanda implements VisualizarDemandaService {
    @Autowired
    private DemandaRepository demandaRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Demanda> consultarDemandaPorID(Integer cantidadTrabajadores) {

        TypedQuery<Demanda> query = entityManager.createQuery(
                "SELECT e FROM Demanda e WHERE e.cantidadtrabajador = :cantidadTrabajadores",
                Demanda.class);
        query.setParameter("cantidadTrabajadores", cantidadTrabajadores);

        return query.getResultList();
    }
    @Override
    public List<Demanda> consultarDemandaPorMes(Mes mes) {

        TypedQuery<Demanda> query = entityManager.createQuery(
                "SELECT e FROM Demanda e WHERE e.nombre_mes = :incrementoMes",
                Demanda.class);
        query.setParameter("incrementoMes", mes);

        return query.getResultList();
    }
}
