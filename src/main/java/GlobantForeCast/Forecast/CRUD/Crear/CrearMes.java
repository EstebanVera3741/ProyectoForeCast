package GlobantForeCast.Forecast.CRUD.Crear;

import GlobantForeCast.Forecast.Repositorio.MesRepository;
import GlobantForeCast.Forecast.Service.InsertarService.CrearMesService;
import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearMes implements CrearMesService {

    @Autowired
    private MesRepository mesRepository;

    @Override
    public Mes crearMes(Mes mes) {
        return this.mesRepository.save(mes);
    }
}