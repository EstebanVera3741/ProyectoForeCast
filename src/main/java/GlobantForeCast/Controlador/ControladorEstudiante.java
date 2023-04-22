package GlobantForeCast.Controlador;

import GlobantForeCast.Modelo.Entity.Estudiante;
import GlobantForeCast.Query.CRUD.Crear.InsertarEstudiante;
import GlobantForeCast.Query.CRUD.Eliminar.EliminarEstudiante;
import GlobantForeCast.Query.CRUD.Modificar.ModificarEstudiante;
import GlobantForeCast.Query.CRUD.Visualizar.VisualizarEstudiante;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ControladorEstudiante extends HttpServlet {

    @Autowired
    private InsertarEstudiante insertarEstudiante;
    @Autowired
    private EliminarEstudiante eliminarEstudiante;
    @Autowired
    private ModificarEstudiante modificarEstudiante;
    @Autowired
    private VisualizarEstudiante visualizarEstudiante;

    @PostMapping("/crearEstudiante")
    public ResponseEntity<?> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante estudianteCreado = this.insertarEstudiante.crearEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }

    @DeleteMapping("/eliminarEstudiante")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable String identificacion) {
        this.eliminarEstudiante.eliminarEstudiante(identificacion);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modificarEstudiante")
    public ResponseEntity<?> modificarEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante estudianteCreado =
                this.modificarEstudiante.modificarEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }

    @GetMapping("/consultarEstudiantes")
    public ResponseEntity<?> consultarEstudiantes (){
        List<Estudiante> listaDeEstudiantes =
                this.visualizarEstudiante.consultarEstudiantes();
        return ResponseEntity.ok(listaDeEstudiantes);
    }

    @GetMapping("/consultarEstudiante")
    public ResponseEntity<?> consultarEstudiante (@PathVariable String identificacion){
        Estudiante estudiante =
                this.visualizarEstudiante.consultarEstudiante(identificacion);
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping("/consultarEstudiantesPorGeneracion/{nombreGeneracion}")
    public ResponseEntity<?> consultarEstudiantesPorGeneracion (@PathVariable String nombreGeneracion){
        List<Estudiante> listaEstudiantes = visualizarEstudiante.consultarEstudiantesPorGeneracion(nombreGeneracion);

        return ResponseEntity.ok(listaEstudiantes);
    }
}