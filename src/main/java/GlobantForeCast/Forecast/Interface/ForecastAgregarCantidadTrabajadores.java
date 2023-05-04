package GlobantForeCast.Forecast.Interface;

import GlobantForeCast.Modelo.Entity.Trabajador;

import java.util.HashMap;
import java.util.List;

public interface ForecastAgregarCantidadTrabajadores {

    public void agregarCantidadTrabajadores (List<Trabajador> listaTrabajadoresPorMes, String mes);

}
