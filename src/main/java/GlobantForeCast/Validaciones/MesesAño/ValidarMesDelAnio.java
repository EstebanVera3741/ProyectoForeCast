package GlobantForeCast.Validaciones.MesesAño;

import GlobantForeCast.Validaciones.Service.ValidacionesMesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidarMesDelAnio implements ValidacionesMesService {
    @Override
    public int validarMesDelAnio(String mes) {

        List<String> listaMeses = new ArrayList<>();
        listaMeses.add("Enero");
        listaMeses.add("Febrero");
        listaMeses.add("Marzo");
        listaMeses.add("Abril");
        listaMeses.add("Mayo");
        listaMeses.add("Junio");
        listaMeses.add("Julio");
        listaMeses.add("Agosto");
        listaMeses.add("Septiembre");
        listaMeses.add("Octubre");
        listaMeses.add("Noviembre");
        listaMeses.add("Diciembre");

        int numeroMes = 0;

        for (String numeroDelMes: listaMeses){
            if(numeroDelMes.equals(mes)){
                numeroMes = listaMeses.indexOf(numeroDelMes);
                break;
            }
        }

        return numeroMes + 1;
    }
}
