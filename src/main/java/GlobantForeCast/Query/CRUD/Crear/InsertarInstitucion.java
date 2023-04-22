package GlobantForeCast.Query.CRUD.Crear;

import GlobantForeCast.Modelo.Entity.Institucion;
import GlobantForeCast.Modelo.Repositorio.InstitucionRepository;
import GlobantForeCast.Query.Service.InsertarService.InsertarInstitucionService;
import GlobantForeCast.Validaciones.Mayuscula.ValidacionMayusculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertarInstitucion implements InsertarInstitucionService {

    @Autowired
    private InstitucionRepository institucionRepository;
    @Autowired
    private ValidacionMayusculas validacionMayusculas;

    @Override
    public Institucion crearInstitucion(Institucion institucion) {
        Institucion institucionValidada = validacionMayusculas.validarMayusculaInstitucion(institucion);
        return institucionRepository.save(institucionValidada);
    }
}