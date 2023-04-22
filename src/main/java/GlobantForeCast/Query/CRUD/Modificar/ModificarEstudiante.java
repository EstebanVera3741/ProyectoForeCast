package GlobantForeCast.Query.CRUD.Modificar;

import GlobantForeCast.Modelo.Entity.Estudiante;
import GlobantForeCast.Modelo.Repositorio.EstudianteRepository;
import GlobantForeCast.Query.Service.ModificarService.ModificarEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModificarEstudiante implements ModificarEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiante modificarEstudiante(Estudiante estudiante) {
        return this.estudianteRepository.save(estudiante);
    }
}