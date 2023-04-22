package GlobantForeCast.Query.CRUD.Crear;

import GlobantForeCast.Modelo.Entity.Generacion;
import GlobantForeCast.Modelo.Repositorio.GeneracionRepository;
import GlobantForeCast.Query.Service.InsertarService.InsertarGeneracionService;
import GlobantForeCast.Validaciones.Mayuscula.ValidacionMayusculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertarGeneracion implements InsertarGeneracionService {

    @Autowired
    private GeneracionRepository generacionRepository;
    @Autowired
    private ValidacionMayusculas validacionMayusculas;

    @Override
    public Generacion crearGeneracion(Generacion generacion) {
        Generacion generacionValidada = validacionMayusculas.validarMayusculaGeneracion(generacion);
        return generacionRepository.save(generacionValidada);
    }
}