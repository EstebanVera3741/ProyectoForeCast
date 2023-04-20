const INICIO = "Inicio";
const GENERACIONES = "Generaciones";
const GLOBERS = "Globers";
const FORECAST = "Forecast";
const COLABORADOR = "Colaborador";
const TABLAS = "Tablas";

function actualizarContenido(id, contenido) {
  document.getElementById(id).innerText = contenido;
}

actualizarContenido("link_inicio", INICIO);
actualizarContenido("link_forecast", FORECAST);
actualizarContenido("link_globers", GLOBERS);
actualizarContenido("link_generacion", GENERACIONES);
actualizarContenido("link_colaboradores", COLABORADOR);
actualizarContenido("link_tablas", TABLAS);
actualizarContenido("link_generacion_titulo", GENERACIONES);