/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var rol;
$(document).on('ready', function () {
    leerUrl();
    $("#registarPago").on('click', function (event)
    {

        $("#aviso").text("");
        $("#valor").val("");
//se hace llamada al servido para actualizar la deuda
        acutualizarDatosCliente();

        if ($("#deudaCliente").val() == 0)
        {
            DialogoDeuda();
        } else
        {

            $("#dialog-registrarPago").dialog({
                autoOpen: true,
                height: 250,
                width: 350,
                modal: true,
                buttons: {
                    "Pago": registrarPago,
                    Cancel: function () {
                        $(this).dialog("close");
                    }
                },
                close: function () {

                }
            });
        }
    });
    $("#aceptar").on('click', function (event)
    {
        $("#datosCliente").hide();
        $("#cedulaCliente").val("");
    });
    $("#enviar").on('click', function (event) {

        if ($("#cedulaCliente").val() != "") {
            $.post("../ClientesControlador", {oper: "validar", cedula: $("#cedulaCliente").val()}, function (data) {
                ban = $.parseJSON(data).ok;
                if (ban == "mal")
                {
//  $("#datosCliente").attr("style", "display:block");

                    $("#datosCliente").show();
                    acutualizarDatosCliente();
                } else
                {
                    $("#dialog-usuario").dialog({
                        modal: true,
                        buttons: {
                            Ok: function () {
                                $(this).dialog("close");
                            }
                        }
                    });
                }
            });
        } else
        {
            $("#dialog-camposVacios").dialog({
                modal: true,
                buttons: {
                    Ok: function () {
                        $(this).dialog("close");
                    }
                }
            });
        }
    });
    $("#btnConsultarDeuda").on('click', function (event) {

        $("#formBuscar").attr("style", "display.block");
    });
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
    function leerUrl()
    {
        var paramstr = window.location.search.substr(1);
        var paramarr = paramstr.split("&");
        var params = {};
        for (var i = 0; i < paramarr.length; i++) {
            var tmparr = paramarr[i].split("=");
            params[tmparr[0]] = tmparr[1];
        }
        rol = params['rol'];
    }
    function registrarPago()
    {
//validar numero negativo
    
        if ($("#valor").val() == "")
        {
            $("#aviso").val("ingrese valor");
        }
        else
        {
            acutualizarDatosCliente();
            if ($("#deudaCliente").val() == 0)
            {
                $("#aviso").text("Usted no tiene deuda");
                //alert(parseFloat($("#valor").val()));
            } else if (parseFloat($("#deudaCliente").val())< parseFloat($("#valor").val()))
            { 
               
                $("#aviso").text("El valor el mayor a su deuda");
            } else if ($("#valor").val() < 0)
            {
                $("#aviso").text("valor negativo");
            }
            else
            {
                $.ajax({
                    data: {oper: "abonos", id_cliente: $("#cedulaCliente").val(), valor: $("#valor").val()},
                    url: '../ClientesControlador',
                    type: 'POST',
                    success: function () {
                        acutualizarDatosCliente();
                        $(this).dialog("close");
                    }
                })
                $(this).dialog("close");
            }
        }

    }
    function acutualizarDatosCliente() {
        $.ajax({
            data: {oper: "buscarCliente", cedula: $("#cedulaCliente").val()},
            url: '../ClientesControlador',
            type: 'POST',
            success: function (data) {
                $("#nombreCliente").attr("value", "" + $.parseJSON(data).nombre);
                $("#deudaCliente").attr("value", "" + $.parseJSON(data).deuda);
            },
            async: false, // La petición es síncrona
            cache: false // No queremos usar la caché del navegador
        });
    }
    function  DialogoDeuda() {
        $("#dialog-deuda").dialog({
            modal: true,
            buttons: {
                Ok: function () {
                    $(this).dialog("close");
                }
            }
        });
    }


});


