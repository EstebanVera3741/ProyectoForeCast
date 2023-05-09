package GlobantForeCast.Forecast.CRUD.Crear;

import GlobantForeCast.Forecast.Repositorio.DemandaRepository;
import GlobantForeCast.Forecast.Service.InsertarService.CrearDemandaService;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearDemanda implements CrearDemandaService {

    @Autowired
    private DemandaRepository demandaRepository;
    @Override
    public Demanda crearDemanda(Demanda demanda) {
        return demandaRepository.save(demanda);
    }
}
