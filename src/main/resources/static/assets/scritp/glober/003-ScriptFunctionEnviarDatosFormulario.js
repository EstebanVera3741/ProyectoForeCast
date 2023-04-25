async function dataCollection() {

    const urlRestController = {
        ciudad: '/crearCiudad',
        generacion: '/crearGeneracion',
        institucion: '/crearInstitucion',
        estudiante: '/crearEstudiante'
    };

    const {value: nombreCompleto} = document.getElementById("input_nombre_completo");
    const {value: numeroIdentificacion} = document.getElementById("input_identificacion");
    const {value: nombreGeneracion} = document.getElementById("input_generacion");
    const {value: correoElectronico} = document.getElementById("input_correo");
    const {value: nombreInstitucion} = document.getElementById("input_education");
    const {value: nombreCiudad} = document.getElementById("input_ciudad");
    const {value: fechaIL} = document.getElementById("input_fecha_il");
    const {value: fechaFP} = document.getElementById("input_fecha_fp");

    const ciudad = { nombreCiudad: nombreCiudad };
    const generacion = { nombreGeneracion: nombreGeneracion, fechaIL: fechaIL, fechaFP: fechaFP,
        nombre_Ciudad: ciudad };
    const institucion = { nombreInstitucion: nombreInstitucion, nombre_Ciudad: ciudad };
    const estudiante = { nombreCompleto: nombreCompleto, numeroIdentificacion: numeroIdentificacion,
        correoElectronico: correoElectronico,
        nombre_Generacion: generacion, nombre_Institucion: institucion };

    console.log(estudiante)


    try {
        const responseCiudad = await fetch(urlRestController.ciudad, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(ciudad)
        });

        const responseGeneracion = await fetch(urlRestController.generacion, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(generacion)
        });

        const responseInstitucion = await fetch(urlRestController.institucion, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(institucion)
        });

        const responseEstudiante = await fetch(urlRestController.estudiante, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(estudiante)
        });

        console.log(responseCiudad, responseGeneracion, responseInstitucion,responseEstudiante);
    }
    catch (error) {
        console.error(error);
    }
}