package GlobantForeCast.Query.Service.VisualizarService;

import GlobantForeCast.Modelo.Entity.Trabajador;
import java.util.List;

public interface VisualizarTrabajadorService {

    public List<Trabajador> consultarTrabajadores();
    public Trabajador consultarTrabajador (String identificacion);
    public Long contarTrabajadores ();
    public List<Trabajador> cantidadTrabajadoresPorMes (int numeroMes);
}