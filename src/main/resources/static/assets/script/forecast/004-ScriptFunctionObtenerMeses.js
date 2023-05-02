function cantidadFaltante (){

    var textoTitulo = 5;
    var urlEndpoint = "/consultarTrabajadoresPorGeneracion/" + textoTitulo;

    fetch(urlEndpoint)
        .then(response => response.json())
        .then(data => {

            console.log("Prueba de Ejecucion: ");
            console.log(data);
        });
}