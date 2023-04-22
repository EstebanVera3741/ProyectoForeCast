package GlobantForeCast.Query.CRUD.Crear;

import GlobantForeCast.Modelo.Entity.Estudiante;
import GlobantForeCast.Modelo.Repositorio.EstudianteRepository;
import GlobantForeCast.Query.Service.InsertarService.InsertarEstudianteService;
import GlobantForeCast.Validaciones.Mayuscula.ValidacionMayusculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertarEstudiante implements InsertarEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private ValidacionMayusculas validacionMayusculas;

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        Estudiante estudianteValidado = validacionMayusculas.validarMayusculaEstudiante(estudiante);
        return this.estudianteRepository.save(estudianteValidado);
    }
}