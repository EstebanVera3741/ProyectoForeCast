package GlobantForeCast.Validaciones.Service;

public interface ValidacionesService {
    public Long cantidadPatrocinados(Long cantidadTrabajadores);
    public Long cantidadFaltantePatrocinios(Long cantidadTrabajadores, Long cantidadEstudiantes);
}
