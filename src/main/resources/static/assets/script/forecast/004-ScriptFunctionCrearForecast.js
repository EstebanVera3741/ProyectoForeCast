

function generarForecast() {
    var labels = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio'];

    const canvas = document.getElementById('myCanvas');
    const ctx = canvas.getContext('2d');


    cantidad(labels, ctx, canvas);

}

function graficarCanvas (labels, data, ctx, canvas){

    const chartWidth = 600;
    const chartHeight = 300;
    const chartMargin = 40;

    // Establecer la escala del eje y
    const maxValue = Math.max(...data);
    const yScale = (chartHeight - chartMargin * 2) / maxValue;

    // Dibujar el fondo del gráfico
    ctx.fillStyle = '#f7f7f7';
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    // Dibujar el eje y
    ctx.beginPath();
    ctx.moveTo(chartMargin, chartMargin);
    ctx.lineTo(chartMargin, chartHeight - chartMargin);
    ctx.lineWidth = 2;
    ctx.strokeStyle = '#666';
    ctx.stroke();

    // Dibujar el eje x
    ctx.beginPath();
    ctx.moveTo(chartMargin, chartHeight - chartMargin);
    ctx.lineTo(chartMargin + chartWidth, chartHeight - chartMargin);
    ctx.stroke();

    // Dibujar las marcas del eje y y las etiquetas
    ctx.font = '14px Arial';
    ctx.textAlign = 'right';
    ctx.fillStyle = '#666';
    for (let i = 0; i <= 5; i++) {
        const value = maxValue / 5 * i;
        const y = chartHeight - chartMargin - value * yScale;
        ctx.beginPath();
        ctx.moveTo(chartMargin - 5, y);
        ctx.lineTo(chartMargin, y);
        ctx.stroke();
        ctx.fillText(value.toString(), chartMargin - 10, y + 5);
    }

    // Dibujar las marcas del eje x y las etiquetas
    const labelSpacing = chartWidth / (data.length - 1);
    ctx.textAlign = 'center';
    for (let i = 0; i < data.length; i++) {
        const x = chartMargin + labelSpacing * i;
        ctx.beginPath();
        ctx.moveTo(x, chartHeight - chartMargin);
        ctx.lineTo(x, chartHeight - chartMargin + 5);
        ctx.stroke();
        ctx.fillText(labels[i], x, chartHeight - chartMargin + 20);
    }

    // Dibujar la línea de la gráfica
    ctx.beginPath();
    ctx.moveTo(chartMargin, chartHeight - chartMargin - data[0] * yScale);

    for (let i = 1; i < data.length; i++) {
        const x = chartMargin + labelSpacing * i;
        const y = chartHeight - chartMargin - data[i] * yScale;
        ctx.lineTo(x, y);
    }

    ctx.lineWidth = 2;
    ctx.strokeStyle = '#0099ff';
    ctx.stroke();
}

async function cantidad(labels, ctx, canvas) {
    const data = [];
    for (let i = 0; i < labels.length; i++) {
        const texto = labels[i];
        const urlEndpoint = "/consultarTrabajadoresPorForecast/" + texto;
        const response = await fetch(urlEndpoint);
        const datos = await response.json();
        console.log("Prueba Forecast: " + texto);
        console.log(datos);
        data[i] = datos;
    }

    console.log("Verificar meses: " + labels);
    console.log("Verificar valores: " + data);
    graficarCanvas(labels, data, ctx, canvas);
}