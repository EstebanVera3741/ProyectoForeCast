package GlobantForeCast.Query.CRUD.Visualizar;

import GlobantForeCast.Modelo.Entity.Trabajador;
import GlobantForeCast.Modelo.Repositorio.TrabajadorRepository;
import GlobantForeCast.Query.Service.VisualizarService.VisualizarTrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisualizarTrabajador implements VisualizarTrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public List<Trabajador> consultarTrabajadores() {
        return this.trabajadorRepository.findAll();
    }

    @Override
    public Trabajador consultarTrabajador(String identificacion) {
        return trabajadorRepository.findById(identificacion).get();
    }

    @Override
    public Long contarTrabajadores() {
        return trabajadorRepository.count();
    }
}