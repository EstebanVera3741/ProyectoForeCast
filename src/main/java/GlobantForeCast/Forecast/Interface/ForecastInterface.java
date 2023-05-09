package GlobantForeCast.Forecast.Interface;

import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Trabajador;

import java.util.List;

public interface ForecastInterface {

    public void agregarCantidadTrabajadores (List<Integer> listaTrabajadoresXMes, List<String> listaMeses);
    public Mes agregarMesEnLaDemanda(String mes);

}
