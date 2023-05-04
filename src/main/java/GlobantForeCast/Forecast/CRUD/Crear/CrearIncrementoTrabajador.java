package GlobantForeCast.Forecast.CRUD.Crear;

import GlobantForeCast.Forecast.Repositorio.IncrementoTrabajadorRepository;
import GlobantForeCast.Forecast.Service.InsertarService.CrearIncrementoTrabajadorService;
import GlobantForeCast.Modelo.Entity.Forecast.IncrementoTrabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearIncrementoTrabajador implements CrearIncrementoTrabajadorService {

    @Autowired
    private IncrementoTrabajadorRepository incrementoTrabajadorRepository;
    @Override
    public IncrementoTrabajador crearIncrementoTrabajador(IncrementoTrabajador incrementoTrabajador) {
        return incrementoTrabajadorRepository.save(incrementoTrabajador);
    }
}
