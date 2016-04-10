/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).on('ready', function () {
    $("#btnVerClientes").on('click', function (event) {
      
        $("#grid").load("../jsp/clientes.jsp", function () {
            
            if (status === "error") {
                alert("Lo siento, no se pudo dar acceso");
            }
        });
    });
    $("#btnVerProductos").on('click', function (event) {
        
        $("#grid").load("../jsp/productos.jsp", function () {
            
            if (status === "error") {
                alert("Lo siento, no se pudo dar acceso");
            }
        });
    });
});
