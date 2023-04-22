package GlobantForeCast.Query.Service.VisualizarService;

import GlobantForeCast.Modelo.Entity.Estudiante;
import java.util.List;

public interface VisualizarEstudiantesService {

    public List<Estudiante> consultarEstudiantes ();
    public Estudiante consultarEstudiante (String identificacion);
    public List<Estudiante> consultarEstudiantesPorGeneracion (String nombreGeneracion);
}