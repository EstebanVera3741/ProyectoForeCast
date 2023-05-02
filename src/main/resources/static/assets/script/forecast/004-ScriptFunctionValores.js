export function cantidadTrabajadores (){
    fetch('/cantidadTrabajadores')
        .then(response => response.json())
        .then(data => {

            var cantidadTrabajadores = document.getElementById("cantidad_trabajadores");
            cantidadTrabajadores.innerText = data;
        });
}

export function cantidadPatrocinados (){
    fetch('/cantidadEstudiantes')
        .then(response => response.json())
        .then(data => {

            var cantidadEstudiantes = document.getElementById("cantidad_estudiantes");
            cantidadEstudiantes.innerText = data;
        });
}

export function cantidadParaPatrocinar (){
    fetch('/cantidadEstudiantesPatrocinar')
        .then(response => response.json())
        .then(data => {

            var cantidadPatrocinar = document.getElementById("cantidad_para_patrocinar");
            cantidadPatrocinar.innerText = data;
        });
}

export function cantidadFaltante (){
    fetch('/cantidadFaltante')
        .then(response => response.json())
        .then(data => {

            var cantidadFaltante = document.getElementById("cantidad_faltante");
            cantidadFaltante.innerText = data;
        });
}