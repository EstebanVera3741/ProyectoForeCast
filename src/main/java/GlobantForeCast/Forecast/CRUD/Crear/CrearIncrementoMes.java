package GlobantForeCast.Forecast.CRUD.Crear;

import GlobantForeCast.Forecast.Repositorio.IncrementoMesRepository;
import GlobantForeCast.Forecast.Service.InsertarService.CrearIncrementoMesService;
import GlobantForeCast.Modelo.Entity.Forecast.IncrementoMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearIncrementoMes implements CrearIncrementoMesService {

    @Autowired
    private IncrementoMesRepository incrementoMesRepository;

    @Override
    public IncrementoMes crearIncrementoMes(IncrementoMes incrementoMes) {
        return this.incrementoMesRepository.save(incrementoMes);
    }
}