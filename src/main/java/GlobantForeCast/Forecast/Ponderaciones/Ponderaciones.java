package GlobantForeCast.Forecast.Ponderaciones;

import GlobantForeCast.Forecast.CRUD.Crear.CrearPronostico;
import GlobantForeCast.Forecast.CRUD.Visualizar.VisualizarDemanda;
import GlobantForeCast.Forecast.Interface.PonderacionesInterface;
import GlobantForeCast.Modelo.Entity.Forecast.Mes;
import GlobantForeCast.Modelo.Entity.Forecast.Demanda;
import GlobantForeCast.Modelo.Entity.Forecast.Pronostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Ponderaciones implements PonderacionesInterface {


    private static final List<String> listaMeses = new ArrayList<>();
    static {
        listaMeses.add("Enero");
        listaMeses.add("Febrero");
        listaMeses.add("Marzo");
        listaMeses.add("Abril");
        listaMeses.add("Mayo");
        listaMeses.add("Junio");
        listaMeses.add("Julio");
        listaMeses.add("Agosto");
        listaMeses.add("Septiembre");
        listaMeses.add("Octubre");
        listaMeses.add("Noviembre");
        listaMeses.add("Diciembre");
    }
    private static final List<Double> listaDePonderaciones = new ArrayList<>();
    static {
        listaDePonderaciones.add(0.1);
        listaDePonderaciones.add(0.2);
        listaDePonderaciones.add(0.3);
        listaDePonderaciones.add(0.4);
    }
    private List<Pronostico> listaPronostico = new ArrayList<>();
    @Autowired
    private VisualizarDemanda visualizarDemanda;
    @Autowired
    private CrearPronostico crearPronostico;


    @Override
    public void realizarCalculoUltimosCuatroMeses() {

        for(int i = 0; i < listaMeses.size(); i++ ){

            List<Integer> listaAux = new ArrayList<>();

            for(int g = i; g < listaMeses.size(); g ++ ){
                Mes mes = new Mes();
                mes.setNombremes(listaMeses.get(g));

                List<Demanda> listaDemanda = visualizarDemanda.consultarDemandaPorMes(mes);

                if(listaAux.size() == 4){

                    Integer valorPromedio = 0;

                    for(int j = 0; j < listaDePonderaciones.size(); j++ ){

                        Double total =  listaDePonderaciones.get(j) * listaAux.get(j);
                        total = total * 0.2 + total;
                        valorPromedio += total.intValue();
                    }
                    Pronostico pronostico = new Pronostico();
                    pronostico.setCantidadpronostico(valorPromedio);
                    pronostico.setNombre_mes(mes);
                    pronostico.setIdentificaciontrabajador(listaDemanda.get(0));
                    crearPronostico.crearPronostico(pronostico);
                    listaPronostico.add(pronostico);
                    break;
                }

                listaAux.add(listaDemanda.get(0).getCantidadtrabajador());

            }
        }

        realizarDemasPronosticos();
    }

    public void realizarDemasPronosticos (){
        for (Pronostico pronostico : listaPronostico){
            Mes mes = pronostico.getNombre_mes();
            Integer cantidadtrabajador = pronostico.getCantidadpronostico();
            visualizarDemanda.actualizarFuturosMeses(mes, cantidadtrabajador);
        }

    }
}
