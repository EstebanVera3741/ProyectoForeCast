package GlobantForeCast.Validaciones.Service;

import GlobantForeCast.Modelo.Entity.Forecast.Demanda;

import java.util.List;

public interface ValidacionesService {
    public Long cantidadPatrocinados(Long cantidadTrabajadores);
    public Long cantidadFaltantePatrocinios(Long cantidadTrabajadores, Long cantidadEstudiantes);
    public int cantidadPatrocinios(List<Demanda> listaPronosticoPorMes);
}
