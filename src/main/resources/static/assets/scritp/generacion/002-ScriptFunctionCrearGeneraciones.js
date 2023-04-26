fetch('/consultarGeneraciones')
    .then(response => response.json())
    .then(data => {

        var contenedorDiv = document.getElementById("script_crear_generacion");
        var cont = 0;

        data.forEach(function (datos){

            var primerDiv = document.createElement("div");
            primerDiv.classList.add("col-lg-4");

            var primerH2 = document.createElement("h2");
            primerH2.classList.add("fw-normal");
            primerH2.setAttribute("id", "value_generacion_" + cont);
            primerH2.innerText = datos.nombreGeneracion;

            var primerP = document.createElement("p");
            primerP.innerText = "podemos ubicar en este espacio una descripcion de la generacion";

            var segundoP = document.createElement("p");
            var primerA = document.createElement("a");
            primerA.classList.add("btn", "btn-secondary", "rounded-pill");
            primerA.setAttribute("id", "link_prueba")
            primerA.setAttribute("href", "#");
            primerA.addEventListener("click", crearTabla);
            primerA.innerText = "Generar Tabla"

            cont ++;

            segundoP.appendChild(primerA);
            primerDiv.appendChild(primerH2)
            primerDiv.appendChild(primerP);
            primerDiv.appendChild(segundoP);
            contenedorDiv.appendChild(primerDiv);
        })
    });