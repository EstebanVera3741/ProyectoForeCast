export function graficarCanvas(labels, data, ctx, canvas, colorLinea, colorPuntos, colorHover) {
    const char = new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [{
                label: "Forecast",
                data: data,
                borderColor: colorLinea,
                pointBackgroundColor: colorPuntos,
                pointHoverBackgroundColor: colorHover,
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
            showModal(label, value);
        }
    }
}

function showModal(label, value) {
    const exampleModal = new bootstrap.Modal(document.getElementById('exampleModal')); // Reemplaza 'exampleModal' con el ID correcto de tu modal
    var nuevoTitulo = document.getElementById("exampleModalLabel");
    nuevoTitulo.innerText = label;
    var nuevoValor = document.getElementById("valor_mes");
    nuevoValor.innerText = value;
    exampleModal.show();
}