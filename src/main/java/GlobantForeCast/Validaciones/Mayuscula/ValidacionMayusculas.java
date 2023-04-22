package GlobantForeCast.Validaciones.Mayuscula;

import GlobantForeCast.Modelo.Entity.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ValidacionMayusculas {

    public Departamento validarMayusculaDepartamento (@NotNull Departamento departamento){
        departamento.setNombreDepartamento(departamento.getNombreDepartamento().toUpperCase());
        return departamento;
    }

    public Ciudad validarMayusculaCiudad (@NotNull Ciudad ciudad){
        ciudad.setNombreCiudad(ciudad.getNombreCiudad().toUpperCase());
        return ciudad;
    }

    public Generacion validarMayusculaGeneracion (@NotNull Generacion generacion){
        generacion.setNombreGeneracion(generacion.getNombreGeneracion().toUpperCase());
        return generacion;
    }

    public Institucion validarMayusculaInstitucion (@NotNull Institucion institucion){
        institucion.setNombreInstitucion(institucion.getNombreInstitucion().toUpperCase());
        return  institucion;
    }

    public Estudiante validarMayusculaEstudiante (@NotNull Estudiante estudiante){
        estudiante.setNombreCompleto(estudiante.getNombreCompleto().toUpperCase());
        return estudiante;
    }
}