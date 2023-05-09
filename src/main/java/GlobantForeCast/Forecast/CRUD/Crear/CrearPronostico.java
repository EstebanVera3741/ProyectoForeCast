package GlobantForeCast.Forecast.CRUD.Crear;

import GlobantForeCast.Forecast.Repositorio.PronosticoRepository;
import GlobantForeCast.Forecast.Service.InsertarService.CrearPronosticoService;
import GlobantForeCast.Modelo.Entity.Forecast.Pronostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearPronostico implements CrearPronosticoService {

    @Autowired
    private PronosticoRepository pronosticoRepository;

    @Override
    public Pronostico crearPronostico(Pronostico pronostico) {
        return pronosticoRepository.save(pronostico);
    }
}
