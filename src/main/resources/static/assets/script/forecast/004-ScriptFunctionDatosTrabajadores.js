
const formulario = document.getElementById('link_formulario_trabajador');

formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    ejecucionEvento();
});

function ejecucionEvento(){

    const URLtrabajador = "/crearTrabajador";

    const {value: numeroTrabajadores} = document.forms["link_formulario_trabajador"]["input_numero_trabajadores"];
    const {value: fechaIngreso} = document.forms["link_formulario_trabajador"]["input_fecha_contratacion"];

    const registroTrabajador = { numeroTrabajadores: numeroTrabajadores,
        fechaIngreso: fechaIngreso };

    try {

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

    setTimeout(function() {
        location.reload();
    }, 500);

}