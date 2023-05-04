package GlobantForeCast.Validaciones.MesesAnio;

import GlobantForeCast.Validaciones.Service.AgregarMesService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class MesesDelAnio implements AgregarMesService {
    private static final Map<String, Integer> mesesDelAnio = new HashMap<>();

    static {
        mesesDelAnio.put("Enero", 1);
        mesesDelAnio.put("Febrero", 2);
        mesesDelAnio.put("Marzo", 3);
        mesesDelAnio.put("Abril", 4);
        mesesDelAnio.put("Mayo", 5);
        mesesDelAnio.put("Junio", 6);
        mesesDelAnio.put("Julio", 7);
        mesesDelAnio.put("Agosto", 8);
        mesesDelAnio.put("Septiembre", 9);
        mesesDelAnio.put("Octubre", 10);
        mesesDelAnio.put("Noviembre", 11);
        mesesDelAnio.put("Diciembre", 12);
    }

    @Override
    public Integer numeroDelMes (String mes){
        return mesesDelAnio.get(mes);
    }
}