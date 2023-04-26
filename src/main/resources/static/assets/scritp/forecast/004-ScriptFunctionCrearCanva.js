
const tabla = document.getElementById("datos");
const filas = tabla.getElementsByTagName("tr");
const valores = [];

for (let i = 1; i < filas.length; i++) {
    const celdas = filas[i].getElementsByTagName("td");
    const valor = parseInt(celdas[1].textContent);
    valores.push(valor);
}

const canvas = document.querySelector("#myCanvas");
const ctx = canvas.getContext("2d");

const startX = 50;
const startY = 400;
const maxHeight = 300;

ctx.beginPath();
ctx.moveTo(startX, startY);

for (let i = 0; i < valores.length; i++) {
    const height = (valores[i] / 20) * maxHeight;
    const x = startX + i * ((canvas.width - startX) / valores.length);
    const y = startY - height;

    ctx.lineTo(x, y);
}

ctx.stroke();

ctx.font = "20px Arial";
ctx.fillText("Valores", startX - 40, startY - maxHeight - 20);

ctx.fillText("Categorías", canvas.width / 2 - 30, startY + 50);

ctx.beginPath();
ctx.moveTo(startX - 10, startY);
ctx.lineTo(canvas.width - 10, startY);
ctx.stroke();

ctx.beginPath();
ctx.moveTo(startX, startY);
ctx.lineTo(startX, startY - maxHeight - 10);
ctx.stroke();