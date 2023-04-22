package GlobantForeCast.Controlador;

import GlobantForeCast.Modelo.Entity.Ciudad;
import GlobantForeCast.Query.CRUD.Crear.InsertarCiudad;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorCiudad extends HttpServlet {

    @Autowired
    private InsertarCiudad insertarCiudad;

    @PostMapping("/crearCiudad")
    public ResponseEntity<?> crearCiudad(@RequestBody Ciudad ciudad) {
        Ciudad ciudadCreado = this.insertarCiudad.crearCiudad(ciudad);
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadCreado);
    }
}