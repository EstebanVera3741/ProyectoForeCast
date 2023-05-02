package GlobantForeCast.Validaciones.Conversion;

import GlobantForeCast.Validaciones.Service.ValidacionesService;
import org.springframework.stereotype.Service;

@Service
public class CalcularPatrocinados implements ValidacionesService {

    @Override
    public Long cantidadPatrocinados(Long cantidadTrabajadores) {
        int cantidad = Math.round(cantidadTrabajadores/5);
        Long cantidadPatrocinados = Long.valueOf(cantidad);
        return cantidadPatrocinados;
    }

    @Override
    public Long cantidadFaltantePatrocinios(Long cantidadTrabajadores, Long cantidadEstudiantes) {
        int cantidad = Math.round((cantidadTrabajadores/5)-cantidadEstudiantes);
        Long cantidadFaltantePatrocinados = Long.valueOf(cantidad);
        return cantidadFaltantePatrocinados;
    }
}