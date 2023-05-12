
function generarFore() {
    var labels = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', "Agosto", "Septiembre",
            "Octubre", "Noviembre", "Diciembre"];

    const canvas = document.getElementById('myCanvas');
    const ctx = canvas.getContext('2d');

    const existingChart = Chart.getChart(canvas);
    if (existingChart) {
        existingChart.destroy();
    }

    cantidadPatrocinio(labels, ctx, canvas);

}

function graficarCanv (labels, data, ctx, canvas){

    const chart = new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [{
                label: "Forecast",
                data: data,
                borderColor: "#ff0000",
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
        const activePoints = chart.getElementsAtEventForMode(e, "nearest", { intersect: true }, true);
        if (activePoints.length > 0) {
            const firstPoint = activePoints[0];
            const label = chart.data.labels[firstPoint.index];
            const value = chart.data.datasets[firstPoint.datasetIndex].data[firstPoint.index];
            alert("Cantidad Trabajadores en el MES: " + label + " es: " + value);
        }
    }
}

async function cantidadPatrocinio(labels, ctx, canvas) {
    const data = [];
    for (let i = 0; i < labels.length; i++) {
        const texto = labels[i];
        const urlEndpoint = "/consultarPatrocinados/" + texto;
        const response = await fetch(urlEndpoint);
        const datos = await response.json();
        console.log("Prueba F: " + texto);
        console.log(datos);
        data[i] = datos;
    }

    console.log("Verificar meses: " + labels);
    console.log("Verificar valores: " + data);
    graficarCanv(labels, data, ctx, canvas);
}