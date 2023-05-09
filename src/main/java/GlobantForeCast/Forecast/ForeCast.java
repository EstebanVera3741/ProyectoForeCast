package GlobantForeCast.Forecast;

import GlobantForeCast.Forecast.CRUD.Crear.CrearMes;
import GlobantForeCast.Forecast.CRUD.Crear.CrearDemanda;
import GlobantForeCast.Forecast.CRUD.Visualizar.VisualizarDemanda;
import GlobantForeCast.Forecast.Interface.ForecastInterface;
import GlobantForeCast.Forecast.Ponderaciones.Ponderaciones;
import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import GlobantForeCast.Modelo.Entity.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeCast implements ForecastInterface {

    @Autowired
    private CrearMes crearIncrementoMes;
    @Autowired
    private CrearDemanda crearIncrementoTrabajador;
    @Autowired
    private VisualizarDemanda visualizarIncrementoTrabajador;
    @Autowired
    private Ponderaciones ponderaciones;


    @Override
    public void agregarCantidadTrabajadores(List<Trabajador> listaTrabajadoresPorMes, String mes) {

        Integer numero = listaTrabajadoresPorMes.size();

        Mes mesCreado = agregarMesEnLaDemanda(mes);

        Demanda demandaCreado = new Demanda();
        demandaCreado.setCantidadtrabajador(numero);
        demandaCreado.setNombre_mes(mesCreado);

        crearIncrementoTrabajador.crearDemanda(demandaCreado);

        List<Demanda> listaDeIncremento = visualizarIncrementoTrabajador.consultarDemandaPorID(numero);

        //Realizar ponderaciones en este lugar

        ponderaciones.realizarCalculoUltimosCuatroMeses();

        //-----------------------------------------

        System.out.println("Incremento Trabajador: " + listaDeIncremento.get(0).getCantidadtrabajador());
    }

    @Override
    public Mes agregarMesEnLaDemanda(String mes) {
        Mes mesCreado = new Mes();
        mesCreado.setNombremes(mes);
        crearIncrementoMes.crearMes(mesCreado);
        return mesCreado;
    }
}
