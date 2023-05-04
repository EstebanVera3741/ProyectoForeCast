package GlobantForeCast.Forecast;

import GlobantForeCast.Forecast.Interface.ForecastAgregarCantidadTrabajadores;
import GlobantForeCast.Modelo.Entity.Trabajador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ForeCast implements ForecastAgregarCantidadTrabajadores {

    private static HashMap<String, Integer> arregoValores = new HashMap<>();


    @Override
    public void agregarCantidadTrabajadores(List<Trabajador> listaTrabajadoresPorMes, String mes) {

        Integer numero = listaTrabajadoresPorMes.size();
        arregoValores.put(mes, numero);
    }
}
