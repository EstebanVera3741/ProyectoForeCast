package GlobantForeCast.Controlador;

import GlobantForeCast.Modelo.Entity.Generacion;
import GlobantForeCast.Query.CRUD.Crear.InsertarGeneracion;
import GlobantForeCast.Query.CRUD.Visualizar.VisualizarGeneracion;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorGeneracion extends HttpServlet {

    @Autowired
    private InsertarGeneracion insertarGeneracion;
    @Autowired
    private VisualizarGeneracion visualizarGeneracion;

    @PostMapping("/crearGeneracion")
    public ResponseEntity<?> crearGeneracion(@RequestBody Generacion generacion) {
        Generacion generacionCreado = this.insertarGeneracion.crearGeneracion(generacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(generacionCreado);
    }

    @GetMapping("/consultarGeneraciones")
    public ResponseEntity<?> consultarGeneraciones (){
        List<Generacion> listaDeGeneraciones = visualizarGeneracion.consultarGeneraciones();
        return ResponseEntity.ok(listaDeGeneraciones);
    }
}