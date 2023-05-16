const formulario = document.getElementById("link_formulario_generacion");
formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    const urlRestController = {
        generacion: '/crearGeneracion',
    };

    const {value: nombreGeneracion} = document.forms["link_formulario_generacion"]["input_generacion"];
    const {value: fechaIL} = document.forms["link_formulario_generacion"]["input_fecha_il"];
    const {value: fechaFP} = document.forms["link_formulario_generacion"]["input_fecha_fp"];

    const generacion = { nombreGeneracion: nombreGeneracion, fechaIL: fechaIL, fechaFP: fechaFP};


    try {
        fetch(urlRestController.generacion, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(generacion)
        });
    }
    catch (error) {
        console.error(error);
    }

    formulario.reset();
});