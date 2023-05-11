package GlobantForeCast.Validaciones.Conversion;

import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import GlobantForeCast.Validaciones.Service.ValidacionesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularPatrocinados implements ValidacionesService {

    private static final int VALORCONVERSION = 20;

    @Override
    public Long cantidadPatrocinados(Long cantidadTrabajadores) {
        int cantidad = Math.round(cantidadTrabajadores/VALORCONVERSION);
        Long cantidadPatrocinados = Long.valueOf(cantidad);
        return cantidadPatrocinados;
    }

    @Override
    public Long cantidadFaltantePatrocinios(Long cantidadTrabajadores, Long cantidadEstudiantes) {
        int cantidad = Math.round((cantidadTrabajadores/VALORCONVERSION)-cantidadEstudiantes);
        Long cantidadFaltantePatrocinados = Long.valueOf(cantidad);
        return cantidadFaltantePatrocinados;
    }

    @Override
    public int cantidadPatrocinios(List<Demanda> listaPronosticoPorMes) {
        List<Demanda> cantidadTrabajadores = listaPronosticoPorMes;
        int cantidad = Math.round((cantidadTrabajadores.get(0).getCantidadtrabajador()/VALORCONVERSION));
        return cantidad;
    }
}