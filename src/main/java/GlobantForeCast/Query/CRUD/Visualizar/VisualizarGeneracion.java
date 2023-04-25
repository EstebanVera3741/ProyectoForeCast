package GlobantForeCast.Query.CRUD.Visualizar;

import GlobantForeCast.Modelo.Entity.Generacion;
import GlobantForeCast.Modelo.Repositorio.GeneracionRepository;
import GlobantForeCast.Query.Service.VisualizarService.VisualizarGeneracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisualizarGeneracion implements VisualizarGeneracionService {

    @Autowired
    private GeneracionRepository generacionRepository;

    @Override
    public List<Generacion> consultarGeneraciones() {
        return this.generacionRepository.findAll();
    }

    @Override
    public Generacion consultarGeneracionPorNombre(String nombreGeneracion) {
        Optional<Generacion> generacionOptional = generacionRepository.findById(nombreGeneracion);
        if (!generacionOptional.isPresent()) {
            throw new IllegalArgumentException("No se encontró la generación con nombre: " + nombreGeneracion);
        }
        return generacionOptional.get();
    }
}