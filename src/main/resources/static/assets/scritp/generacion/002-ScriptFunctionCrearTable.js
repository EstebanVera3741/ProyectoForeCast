function crearTabla() {


    const padre = document.querySelector("#script_crear_generacion");
    const divsHijos = padre.querySelectorAll("div");
    var indiceDiv = 0;

    for (let i = 0; i < divsHijos.length; i++) {
        divsHijos[i].addEventListener("click", function() {
            const indice = Array.prototype.indexOf.call(divsHijos, this);
            indiceDiv = indice;
        });
    }

    const nombreGeneracion = document.querySelector("#value_generacion" + indiceDiv);
    console.log("#value_generacion" + indiceDiv);
    const textoH2 = nombreGeneracion.textContent;
    console.log(textoH2);

    const urlEndpoint = "/consultarEstudiantesPorGeneracion" + nombreGeneracion;

    fetch(urlEndpoint)
        .then(response => response.json())
        .then(data => {
            console.log(data);

            const sectionPrincipal = document.getElementById("section_crear_tabla");

            const primerTabla = document.createElement('table');
            primerTabla.classList.add("table", "table-striped");
            const primerCampos = primerTabla.createTHead();
            const primerFila = primerCampos.insertRow();
            const campoNombre = primerFila.insertCell();
            const campoId = primerFila.insertCell();
            const campoCorreo = primerFila.insertCell();

            campoNombre.textContent = 'Nombre Completo';
            campoId.textContent = 'Identificacion';
            campoCorreo.textContent = 'Correo Electronico';

            const cuerpoTabla = primerTabla.createTBody();

            data.forEach(function (datos){

                const fila = cuerpoTabla.insertRow();
                const campoNombre = fila.insertCell();
                const campoId = fila.insertCell();
                const campoCorreo = fila.insertCell();


                campoNombre.textContent = datos.nombreCompleto;
                campoId.textContent = datos.numeroIdentificacion;
                campoCorreo.textContent = datos.correoElectronico;
            })
            sectionPrincipal.appendChild(primerTabla);
        });
}