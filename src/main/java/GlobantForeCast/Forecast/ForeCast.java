package GlobantForeCast.Forecast;

import GlobantForeCast.Forecast.CRUD.Crear.CrearIncrementoMes;
import GlobantForeCast.Forecast.CRUD.Crear.CrearIncrementoTrabajador;
import GlobantForeCast.Forecast.CRUD.Visualizar.VisualizarIncrementoTrabajador;
import GlobantForeCast.Forecast.Interface.ForecastInterface;
import GlobantForeCast.Modelo.Entity.Forecast.IncrementoMes;
import GlobantForeCast.Modelo.Entity.Forecast.IncrementoTrabajador;
import GlobantForeCast.Modelo.Entity.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeCast implements ForecastInterface {

    @Autowired
    private CrearIncrementoMes crearIncrementoMes;
    @Autowired
    private CrearIncrementoTrabajador crearIncrementoTrabajador;
    @Autowired
    private VisualizarIncrementoTrabajador visualizarIncrementoTrabajador;


    @Override
    public void agregarCantidadTrabajadores(List<Trabajador> listaTrabajadoresPorMes, String mes) {

        Integer numero = listaTrabajadoresPorMes.size();

        IncrementoMes incrementoMesCreado = agregarMesEnElIncrementoDelMes(mes);

        IncrementoTrabajador incrementoTrabajadorCreado = new IncrementoTrabajador();
        incrementoTrabajadorCreado.setCantidadtrabajador(numero);
        incrementoTrabajadorCreado.setNombre_mes(incrementoMesCreado);

        crearIncrementoTrabajador.crearIncrementoTrabajador(incrementoTrabajadorCreado);

        incrementoTrabajadorCreado = visualizarIncrementoTrabajador.consultarIdIncrementoTrabajador(numero);

        System.out.println("Incremento Trabajador: " + incrementoTrabajadorCreado.getNumeroidentificacion());
        System.out.println("Incremento Trabajador: " + incrementoTrabajadorCreado.getCantidadtrabajador());
        System.out.println("Incremento Trabajador: " + incrementoTrabajadorCreado.getNombre_mes());
    }

    @Override
    public IncrementoMes agregarMesEnElIncrementoDelMes(String mes) {
        IncrementoMes incrementoMesCreado = new IncrementoMes();
        incrementoMesCreado.setNombremes(mes);
        crearIncrementoMes.crearIncrementoMes(incrementoMesCreado);
        return incrementoMesCreado;
    }
}
