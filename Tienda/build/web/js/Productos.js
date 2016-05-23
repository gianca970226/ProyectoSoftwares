/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    crearGridProductos();
});
function crearGridProductos() {

    jqGridProductos = jQuery('#gridProductos').jqGrid({
        url: '../ProductosControlador',
        datatype: "json",
        mtype: 'POST',
        postData: {
            oper: "1"
        },
        colNames: ['ID PRODUCTO', 'NOMBRE', 'DESCRIPCION', 'CANTIDAD', 'VALOR ', 'DISTRIBUIDOR'],
        colModel: [
            {name: 'id_producto', index: 'id_producto', width: 55, align: 'center', editable: true, editrules: {required: true, number: true}, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'nombre', index: 'nombre', width: 250, editable: true, editrules: {required: true}, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'descripcion', index: 'descripcion', width: 250, editrules: {required: true}, editable: true, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'cantidad', index: 'cantidad', width: 250, editable: false, editrules: {number: true}, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'valor', index: 'valor', width: 250, editable: true, editrules: {requiered: true, number: true}, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'distribuidor', index: 'distribuidor', width: 250, editable: true, editrules: {requiered: true, number: false, }, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }}
        ],
        rowNum: 200,
        width: 700,
        rowList: [200, 700, 1300],
        pager: '#pgridProductos',
        sortname: 'id_producto',
        viewrecords: true,
        sortorder: "asc",
        caption: "Productos",
        multiselect: false,
        editurl: "../ProductosControlador",
    }).jqGrid('navGrid', '#pgridProductos', {
        refresh: true,
        edit: true,
        add: true,
        del: true,
        search: true,
    },
            {// Antes de enviar a obj->edit(...) se agrega un POST
                modal: false, jqModal: false,
                width: 465,
                closeAfterEdit: true,
                beforeSubmit: function ()
                {

                    ban = 0
                    var ban = "bien";
                    var selectedRowId = jqGridProductos.jqGrid('getGridParam', 'selrow');
                    var id = jqGridProductos.jqGrid('getCell', selectedRowId, 'id_producto');
                    if ($("#id_producto").val() != id)
                    {
                        $.ajax({
                            data: {oper: "validar", id: $("#id_producto").val()},
                            url: '../ProductosControlador',
                            type: 'POST',
                            success: function (data) {
                                ban = $.parseJSON(data).ok;
                            },
                            async: false, // La petición es síncrona
                            cache: false // No queremos usar la caché del navegador
                        });
                    }
                    /*  $.post("../ClientesControlador", {oper: "validar", cedula:  closeAfterAdd: true,}, function (data) {
                     
                     });*/
                    if (ban == "mal")
                    {
                        return [false, "El que el nuevo valor ya esta registrado", ""];
                    }
                    else
                    {
                        return [true, "", ""];
                    }

                }

            },
    {// Antes de enviar a obj->add(...) se agrega un POST
        modal: false, jqModal: false,
        width: 465,
        beforeSubmit: function ()
        {
            var ban = "bien";
            $.ajax({
                data: {oper: "validar", id: $("#id_producto").val()},
                url: '../ProductosControlador',
                type: 'POST',
                success: function (data) {
                    ban = $.parseJSON(data).ok;
                },
                async: false, // La petición es síncrona
                cache: false // No queremos usar la caché del navegador
            });
            /*  $.post("../ClientesControlador", {oper: "validar", cedula:  closeAfterAdd: true,}, function (data) {
             });*/
            if (ban == "mal")
            {
                return [false, "El que el nuevo valor ya esta registrado", ""];
            }
            else
            {
                return [true, "", ""];
            }
        }
    },
    {modal: false, jqModal: false,
        width: 300,
    },
            {multipleSearch: true, multipleGroup: false}
    ).navButtonAdd('#pgridProductos', {
        caption: "",
        title: "Agregar Ingreso",
        buttonicon: "ui-icon-circle-plus",
        onClickButton: agregarIngreso,
        position: "last"
    })
}
function agregarIngreso()
{
    var selectedRowId = jqGridProductos.jqGrid('getGridParam', 'selrow');
    var cedula = jqGridProductos.jqGrid('getCell', selectedRowId, 'id_producto');
    var nombre = jqGridProductos.jqGrid('getCell', selectedRowId, 'nombre');
    var valor = jqGridProductos.jqGrid('getCell', selectedRowId, 'valor');
    var id = jqGridProductos.jqGrid('getCell', selectedRowId, 'id_producto');
    if (selectedRowId == null)
    {

        $("#dialog-selecion").dialog();
    } else
    {
        $("#nombreProducto").val(nombre);
        $("#precioProducto").val(valor);
        $("#cantidadProducto").val("");
        $("#error").val("");
        $("#dialog-adicionar").dialog({
            resizable: false,
            height: 270,
            width: 350,
            modal: true,
            draggable: false,
            position: [$(window).width() / 2 - 200, 120],
            buttons: {
                "Aceptar": agregarIngreso,
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });
    }

    function agregarIngreso() {



        if ($("#cantidadProducto").val() < 0)
        {
            $("#error").text("Campo Negativo");
        }
        else if ($("#cantidadProducto").val() == "")
        {
            $("#error").text("Campos cantidad vacio");
        }
        else if ($("#precioProducto").val() == "")
        {
            $("#error").text("Campos valor vacio");
        }
        else {
            $.ajax({
                data: {oper: "ingresos", id: id, precio: $("#precioProducto").val(), cantidad: $("#cantidadProducto").val()},
                url: '../ProductosControlador',
                type: 'POST',
                success: function () {
                    jqGridProductos.trigger("reloadGrid");
                }
            })
            $(this).dialog("close");
        }
    }
}