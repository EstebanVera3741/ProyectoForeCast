const formulario = document.getElementById('link_formulario_envar_datos');
formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    const urlRestController = {
        ciudad: '/crearCiudad',
        generacion: '/crearGeneracion',
        institucion: '/crearInstitucion',
        estudiante: '/crearEstudiante'
    };

    const {value: nombreCompleto} = document.forms["link_formulario_envar_datos"]["input_nombre_completo"];
    const {value: numeroIdentificacion} = document.forms["link_formulario_envar_datos"]["input_identificacion"];
    const {value: nombreGeneracion} = document.forms["link_formulario_envar_datos"]["input_generacion"];
    const {value: correoElectronico} = document.forms["link_formulario_envar_datos"]["input_correo"];
    const {value: nombreInstitucion} = document.forms["link_formulario_envar_datos"]["input_education"];
    const {value: nombreCiudad} = document.forms["link_formulario_envar_datos"]["input_ciudad"];
    const {value: fechaIL} = document.forms["link_formulario_envar_datos"]["input_fecha_il"];
    const {value: fechaFP} = document.forms["link_formulario_envar_datos"]["input_fecha_fp"];

    const ciudad = { nombreCiudad: nombreCiudad };
    const generacion = { nombreGeneracion: nombreGeneracion, fechaIL: fechaIL, fechaFP: fechaFP,
        nombre_Ciudad: ciudad };
    const institucion = { nombreInstitucion: nombreInstitucion, nombre_Ciudad: ciudad };
    const estudiante = { nombreCompleto: nombreCompleto, numeroIdentificacion: numeroIdentificacion,
        correoElectronico: correoElectronico,
        nombre_Generacion: generacion, nombre_Institucion: institucion };

    try {
        const responseCiudad = fetch(urlRestController.ciudad, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(ciudad)
        });
        responseCiudad.then(response =>{
            if(response.status == 201){
                const responseGeneracion = fetch(urlRestController.generacion, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(generacion)
                });
                responseGeneracion.then(response => {
                    if (response.status == 201){
                        const responseInstitucion = fetch(urlRestController.institucion, {
                            method: 'POST',
                            headers: { 'Content-Type': 'application/json' },
                            body: JSON.stringify(institucion)
                        });
                        responseInstitucion.then(response => {
                            if (response.status == 201){
                                const responseEstudiante = fetch(urlRestController.estudiante, {
                                    method: 'POST',
                                    headers: { 'Content-Type': 'application/json' },
                                    body: JSON.stringify(estudiante)
                                });
                            }
                        })
                    }
                })
            }
        })
    }
    catch (error) {
        console.error(error);
    }

    formulario.reset();
});