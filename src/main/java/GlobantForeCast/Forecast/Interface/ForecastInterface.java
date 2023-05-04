package GlobantForeCast.Forecast.Interface;

import GlobantForeCast.Modelo.Entity.Forecast.IncrementoMes;
import GlobantForeCast.Modelo.Entity.Trabajador;

import java.util.List;

public interface ForecastInterface {

    public void agregarCantidadTrabajadores (List<Trabajador> listaTrabajadoresPorMes, String mes);
    public IncrementoMes agregarMesEnElIncrementoDelMes (String mes);

}
