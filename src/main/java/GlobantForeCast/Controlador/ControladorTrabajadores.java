package GlobantForeCast.Controlador;

import GlobantForeCast.Modelo.Entity.Enlace.EnlaceTrabajador;
import GlobantForeCast.Query.CRUD.Crear.InsertarTrabajador;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorTrabajadores extends HttpServlet {

    @Autowired
    private InsertarTrabajador insertarTrabajador;

    @PostMapping("/crearTrabajador")
    public ResponseEntity<?> crearTrabajador (@RequestBody EnlaceTrabajador enlaceTrabajador){

        for(int i = 0; i < enlaceTrabajador.getNumeroTrabajadores(); i++){

        }

        return ResponseEntity.status(HttpStatus.CREATED).body("");

    }
}
