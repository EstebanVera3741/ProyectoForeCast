package GlobantForeCast.Query.Service.VisualizarService;

import GlobantForeCast.Modelo.Entity.Generacion;

import java.util.List;

public interface VisualizarGeneracionService {

    public List<Generacion> consultarGeneraciones();
    public Generacion consultarGeneracionPorNombre(String nombreGeneracion);
}