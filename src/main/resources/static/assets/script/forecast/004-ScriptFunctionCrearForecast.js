

function generarForecast() {
    var labels = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre"];



    const canvas = document.getElementById('myCanvas');
    const ctx = canvas.getContext('2d');

    const existingChart = Chart.getChart(canvas);
    if (existingChart) {
        existingChart.destroy();
    }

    cantidad(labels, ctx, canvas);

}

function graficarCanvas (labels, data, ctx, canvas){

    const char = new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [{
                label: "Forecast",
                data: data,
                borderColor: "#00f7ff",
                pointBackgroundColor: "#ff00f2",
                pointHoverBackgroundColor: "#eeff00",
                pointRadius: 5,
                pointHoverRadius: 7,
                fill: false,
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                    }
                }]
            },
            tooltips: {
                mode: "nearest",
                intersect: false,
                callbacks: {
                    label: function(tooltipItem) {
                        return "Value: " + tooltipItem.yLabel;
                    }
                }
            }
        }
    });

    canvas.onclick = function(e) {
        const activePoints = char.getElementsAtEventForMode(e, "nearest", { intersect: true }, true);
        if (activePoints.length > 0) {
            const firstPoint = activePoints[0];
            const label = char.data.labels[firstPoint.index];
            const value = char.data.datasets[firstPoint.datasetIndex].data[firstPoint.index];
            alert("Cantidad Trabajadores en el MES: " + label + " es: " + value);
        }
    }
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