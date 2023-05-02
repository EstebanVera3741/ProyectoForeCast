package GlobantForeCast.Controlador.Eventos;

import GlobantForeCast.Query.CRUD.Visualizar.VisualizarEstudiante;
import GlobantForeCast.Query.CRUD.Visualizar.VisualizarTrabajador;
import GlobantForeCast.Validaciones.Conversion.CalcularPatrocinados;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorEventos extends HttpServlet {

    @Autowired
    private VisualizarTrabajador visualizarTrabajador;
    @Autowired
    private VisualizarEstudiante visualizarEstudiante;
    @Autowired
    private CalcularPatrocinados calcularPatrocinados;

    @GetMapping("/cantidadEstudiantesPatrocinar")
    public ResponseEntity<?> cantidadEstudiantesPatrocinar (){
        Long cantidadTrabajadores = this.visualizarTrabajador.contarTrabajadores();
        Long cantidadParaPatrocinar = calcularPatrocinados.cantidadPatrocinados(cantidadTrabajadores);
        return ResponseEntity.ok(cantidadParaPatrocinar);
    }

    @GetMapping("/cantidadFaltante")
    public ResponseEntity<?> cantidadFaltantePatrocinios (){
        Long cantidadTrabajadores = this.visualizarTrabajador.contarTrabajadores();
        Long cantidadEstudiantes = this.visualizarEstudiante.contarEstudiantes();
        Long cantidadFaltantePatrocinar = calcularPatrocinados
                .cantidadFaltantePatrocinios(cantidadTrabajadores, cantidadEstudiantes);
        return ResponseEntity.ok(cantidadFaltantePatrocinar);
    }

}
