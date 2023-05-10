package GlobantForeCast.Forecast.CRUD.Crear;

import GlobantForeCast.Forecast.CRUD.Visualizar.VisualizarDemanda;
import GlobantForeCast.Forecast.Repositorio.DemandaRepository;
import GlobantForeCast.Forecast.Service.InsertarService.CrearDemandaService;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrearDemanda implements CrearDemandaService {

    @Autowired
    private DemandaRepository demandaRepository;
    @Autowired
    private VisualizarDemanda visualizarDemanda;
    @Override
    public void crearDemanda(Demanda demanda) {
        try {
            List<Demanda> demandasPorMes = visualizarDemanda.consultarDemandaPorMes(demanda.getNombre_mes());
            if (!demandasPorMes.isEmpty()) {
                actualizarDemandaExistente(demandasPorMes.get(0), demanda);
            }
        } catch (Exception e) {
            demandaRepository.save(demanda);
        }
    }

    private void actualizarDemandaExistente(Demanda demandaExistente, Demanda demandaNueva) {
        demandaExistente.setCantidadtrabajador(demandaNueva.getCantidadtrabajador());
        demandaRepository.save(demandaExistente);
    }
}
