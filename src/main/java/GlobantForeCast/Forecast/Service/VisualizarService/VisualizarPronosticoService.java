package GlobantForeCast.Forecast.Service.VisualizarService;

import GlobantForeCast.Modelo.Entity.Forecast.Demanda;

import java.util.List;

public interface VisualizarPronosticoService {

    public List<Demanda> consultarPronosticoPorMes(int mes);
}
