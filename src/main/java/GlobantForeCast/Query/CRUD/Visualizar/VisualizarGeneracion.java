package GlobantForeCast.Query.CRUD.Visualizar;

import GlobantForeCast.Modelo.Entity.Generacion;
import GlobantForeCast.Modelo.Repositorio.GeneracionRepository;
import GlobantForeCast.Query.Service.VisualizarService.VisualizarGeneracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisualizarGeneracion implements VisualizarGeneracionService {

    @Autowired
    private GeneracionRepository generacionRepository;

    @Override
    public List<Generacion> consultarGeneraciones() {
        return this.generacionRepository.findAll();
    }
}