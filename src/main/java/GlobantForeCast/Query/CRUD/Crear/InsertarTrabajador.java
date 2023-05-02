package GlobantForeCast.Query.CRUD.Crear;

import GlobantForeCast.Modelo.Entity.Trabajador;
import GlobantForeCast.Modelo.Repositorio.TrabajadorRepository;
import GlobantForeCast.Query.Service.InsertarService.InsertarTrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertarTrabajador implements InsertarTrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public void crearTrabajador(Trabajador trabajador) {
        trabajadorRepository.save(trabajador);
    }
}