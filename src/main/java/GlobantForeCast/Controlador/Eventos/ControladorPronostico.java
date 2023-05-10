package GlobantForeCast.Controlador.Eventos;

import GlobantForeCast.Forecast.CRUD.Visualizar.VisualizarPronostico;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Forecast.Pronostico;
import GlobantForeCast.Modelo.Entity.Trabajador;
import GlobantForeCast.Validaciones.MesesAnio.ValidarMesDelAnio;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorPronostico extends HttpServlet {

    @Autowired
    private VisualizarPronostico visualizarPronostico;
    @Autowired
    private ValidarMesDelAnio validarMesDelAnio;

    @GetMapping("/consultarForecastPorGeneracion/{mes}")
    public ResponseEntity<?> consultarForecastPorGeneracion (@PathVariable String mes){

        int numeroMes = validarMesDelAnio.validarMesDelAnio(mes);
        List<Demanda> listaPronosticoPorMes = visualizarPronostico.consultarPronosticoPorMes(numeroMes);

        return ResponseEntity.ok(listaPronosticoPorMes);
    }

}
