package GlobantForeCast.Query.CRUD.Eliminar;

import GlobantForeCast.Modelo.Repositorio.EstudianteRepository;
import GlobantForeCast.Query.Service.EliminarService.EliminarEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminarEstudiante implements EliminarEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void eliminarEstudiante(String identificacion) {
        this.estudianteRepository.deleteById (identificacion);
    }
}