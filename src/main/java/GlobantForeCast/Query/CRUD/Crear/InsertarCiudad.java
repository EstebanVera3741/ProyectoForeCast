package GlobantForeCast.Query.CRUD.Crear;

import GlobantForeCast.Modelo.Entity.Ciudad;
import GlobantForeCast.Modelo.Repositorio.CiudadRepository;
import GlobantForeCast.Query.Service.InsertarService.InsertarCiudadService;
import GlobantForeCast.Validaciones.Mayuscula.ValidacionMayusculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertarCiudad implements InsertarCiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;
    @Autowired
    private ValidacionMayusculas validacionMayusculas;

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) {
        Ciudad ciudadValidada = validacionMayusculas.validarMayusculaCiudad(ciudad);
        return ciudadRepository.save(ciudadValidada);
    }
}