const formulario = document.getElementById('link_formulario_trabajador');
formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    const URLtrabajador = "/crearTrabajador";

    const {value: numeroTrabajadores} = document.forms["link_formulario_trabajador"]["input_numero_trabajadores"];
    const {value: fechaFC} = document.forms["link_formulario_trabajador"]["input_fecha_contratacion"];

    const registroTrabajador = { numeroTrabajadores: numeroTrabajadores,
        fechaFC: fechaFC };

    try {

        console.log("Prueba---1: " + registroTrabajador.numeroTrabajadores);

        fetch(URLtrabajador, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(registroTrabajador)
        });
    }
    catch (error) {
        console.error(error);
    }
    formulario.reset();
});