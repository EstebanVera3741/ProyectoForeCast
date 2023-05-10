package GlobantForeCast.Forecast.Service.VisualizarService;

import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;

import java.util.List;

public interface VisualizarDemandaService {
    public List<Demanda> consultarDemandaPorID(Integer cantidadTrabajadores);
    public List<Demanda> consultarDemandaPorMes(Mes mes);
    public void actualizarFuturosMeses(Mes mes, Integer nuevaCantidad);

}