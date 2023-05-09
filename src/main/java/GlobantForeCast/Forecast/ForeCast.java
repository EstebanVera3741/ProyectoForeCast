package GlobantForeCast.Forecast;

import GlobantForeCast.Forecast.CRUD.Crear.CrearMes;
import GlobantForeCast.Forecast.CRUD.Crear.CrearDemanda;
import GlobantForeCast.Forecast.CRUD.Visualizar.VisualizarDemanda;
import GlobantForeCast.Forecast.Interface.ForecastInterface;
import GlobantForeCast.Forecast.Ponderaciones.Ponderaciones;
import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
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
    public void agregarCantidadTrabajadores(List<Integer> listaTrabajadoresXMes, List<String> listaMeses) {

        for (int i = 0; i < listaTrabajadoresXMes.size(); i++){

            Demanda demandaCreado = new Demanda();
            demandaCreado.setCantidadtrabajador(listaTrabajadoresXMes.get(i));
            Mes mes = agregarMesEnLaDemanda(listaMeses.get(i));
            demandaCreado.setNombre_mes(mes);

            crearIncrementoTrabajador.crearDemanda(demandaCreado);
        }

        ponderaciones.realizarCalculoUltimosCuatroMeses();
    }

    @Override
    public Mes agregarMesEnLaDemanda(String mes) {
        Mes mesCreado = new Mes();
        mesCreado.setNombremes(mes);
        crearIncrementoMes.crearMes(mesCreado);
        return mesCreado;
    }
}
