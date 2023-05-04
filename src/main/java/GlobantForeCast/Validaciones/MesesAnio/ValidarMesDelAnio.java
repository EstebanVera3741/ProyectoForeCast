package GlobantForeCast.Validaciones.MesesAnio;

import GlobantForeCast.Validaciones.Service.ValidacionesMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidarMesDelAnio implements ValidacionesMesService {

    @Autowired
    private MesesDelAnio mesesDelAnio;
    @Override
    public Integer validarMesDelAnio(String mes) {

        int numeroMes = mesesDelAnio.numeroDelMes(mes);
        return numeroMes;
    }
}
