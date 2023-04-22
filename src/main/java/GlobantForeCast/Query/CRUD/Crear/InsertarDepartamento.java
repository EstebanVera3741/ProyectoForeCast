package GlobantForeCast.Query.CRUD.Crear;

import GlobantForeCast.Modelo.Entity.Departamento;
import GlobantForeCast.Modelo.Repositorio.DepartamentoRepository;
import GlobantForeCast.Query.Service.InsertarService.InsertarDepartamentoService;
import GlobantForeCast.Validaciones.Mayuscula.ValidacionMayusculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertarDepartamento implements InsertarDepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private ValidacionMayusculas validacionMayusculas;

    @Override
    public Departamento crearDepartamento(Departamento departamento) {
        Departamento departamentoValidado = validacionMayusculas.validarMayusculaDepartamento(departamento);
        return departamentoRepository.save(departamentoValidado);
    }
}