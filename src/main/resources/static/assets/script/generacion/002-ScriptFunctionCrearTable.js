function crearTabla() {

    var existenciaTabla = document.getElementById("link_eliminar_tabla");
    if(existenciaTabla){
        eliminarTabla();
    }
    else {
        const padre = document.querySelector("#script_crear_generacion");
        const divsHijos = padre.querySelectorAll("div");
        var indiceDiv = 0;

        for (let i = 0; i < divsHijos.length; i++) {
            divsHijos[i].addEventListener("click", function () {
                var indice = Array.prototype.indexOf.call(divsHijos, this);
                indiceDiv = indice;
                generarTable(indiceDiv);
            });
        }
    }
}

function generarTable (indiceDiv){

    var nombreGeneracion = document.querySelector("#value_generacion_" + indiceDiv);
    var textoTitulo = nombreGeneracion.textContent;
    var urlEndpoint = "/consultarEstudiantesPorGeneracion/" + textoTitulo;

    fetch(urlEndpoint)
        .then(response => response.json())
        .then(data => {

            const sectionPrincipal = document.getElementById("section_crear_tabla");

            const primerTabla = document.createElement('table');
            primerTabla.classList.add("table", "table-striped");
            primerTabla.setAttribute("id", "link_eliminar_tabla");

            const primerCampo = document.createElement("thead");
            const primerFila = document.createElement("tr");

            const campoNombre = document.createElement("th");
            const campoId = document.createElement("th");
            const campoCorreo = document.createElement("th");

            campoNombre.innerText = 'Nombre Completo';
            primerFila.appendChild(campoNombre);
            campoId.innerText = 'Identificacion';
            primerFila.appendChild(campoId);
            campoCorreo.innerText = 'Correo Electronico';
            primerFila.appendChild(campoCorreo);

            const cuerpoTabla = document.createElement("tbody");

            primerCampo.appendChild(primerFila);
            primerTabla.appendChild(primerCampo);

            data.forEach(function (datos){

                var fila = document.createElement("tr");

                var campoNombre = document.createElement("td");
                campoNombre.innerText = datos.nombreCompleto;
                fila.appendChild(campoNombre);

                var campoId = document.createElement("td");
                campoId.innerText = datos.numeroIdentificacion;
                fila.appendChild(campoId);

                var campoCorreo = document.createElement("td");
                campoCorreo.innerText = datos.correoElectronico;
                fila.appendChild(campoCorreo);

                cuerpoTabla.appendChild(fila);
            })
            primerTabla.appendChild(cuerpoTabla);
            sectionPrincipal.appendChild(primerTabla);
        });
}

function eliminarTabla() {
    var tablaCreada = document.getElementById("link_eliminar_tabla");
    var sectionContenedorTabla = tablaCreada.parentNode;
    sectionContenedorTabla.removeChild(tablaCreada);
}