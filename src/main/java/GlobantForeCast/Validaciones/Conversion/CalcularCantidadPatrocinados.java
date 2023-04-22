package GlobantForeCast.Validaciones.Conversion;

import GlobantForeCast.Query.CRUD.Visualizar.VisualizarTrabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcularCantidadPatrocinados {
    @Autowired
    private VisualizarTrabajador visualizarTrabajador;

    public void cantidadTrabajadores (){
        Long numeroTrabajadores = visualizarTrabajador.contarTrabajadores();
        System.out.println(numeroTrabajadores);
    }
}