package GlobantForeCast.Controlador;

import GlobantForeCast.Modelo.Entity.Institucion;
import GlobantForeCast.Query.CRUD.Crear.InsertarInstitucion;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorInstitucion extends HttpServlet {

    @Autowired
    private InsertarInstitucion insertarInstitucion;

    @PostMapping("/crearInstitucion")
    public ResponseEntity<?> crearInstitucion(@RequestBody Institucion institucion) {
        Institucion institucionCreado = this.insertarInstitucion.crearInstitucion(institucion);
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionCreado);
    }
}