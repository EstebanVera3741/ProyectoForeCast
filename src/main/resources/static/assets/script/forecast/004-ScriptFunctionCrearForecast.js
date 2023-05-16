import {graficarCanvas} from "./004-ScriptFunctionGenerarGrafica.js";

const url1 = "/consultarTrabajadoresPorForecast/";
const url2 = "/consultarForecastPorGeneracion/";
const url3 = "/consultarPatrocinados/";

const botonGenerarTrabajadores = document.getElementById("grafica_trabajadores");
const botonGenerarForecastLaboral = document.getElementById("grafica_forecast_laboral");
const botonGenerarForecastPatrocinio = document.getElementById("grafica_forecast_patrocinio");
botonGenerarTrabajadores.addEventListener('click', () => {
    generarGraficaTrabajadores(url1);
});
botonGenerarForecastLaboral.addEventListener("click", () => {
    generarGraficaTrabajadores(url2);
});
botonGenerarForecastPatrocinio.addEventListener("click", () => {
    generarGraficaTrabajadores(url3);
});

function generarGraficaTrabajadores(url) {

    const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

    const canvas = document.getElementById('myCanvas');
    const formaGrafico = canvas.getContext('2d');

    const existingChart = Chart.getChart(canvas);
    if (existingChart) {
        existingChart.destroy();
    }

    consultarCantidadTrabajadores(meses, formaGrafico, canvas, url);
}

async function consultarCantidadTrabajadores(meses, formaGrafico, canvas, url) {
    const data = [];
    for (let i = 0; i < meses.length; i++) {
        const texto = meses[i];
        const urlEndpoint = url + texto;
        const response = await fetch(urlEndpoint);
        data[i] = await response.json();
    }
    const colorLinea = "#050505";
    const colorPuntos = "#a9a9a9";
    const colorHover = "#ffffff";

    graficarCanvas(meses, data, formaGrafico, canvas, colorLinea, colorPuntos, colorHover);
}