/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
   crearGridClientes();
});
function crearGridClientes() {

    jqGridClientes = jQuery('#gridClientes').jqGrid({
        url: '../ClientesControlador',
        datatype: "json",
        mtype: 'POST',
        postData: {
            oper: "1"
        },
        colNames: ['CEDULA', 'NOMBRE', 'APELLIDOS', 'CELULAR', 'DIRECCION', 'DEUDA'],
        colModel: [
            {name: 'cedula', index: 'cedula', width: 55, align: 'center', editable: false, editrules: {required: true, number: true}, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'nombre', index: 'nombre', width: 250, editable: true, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'apellido', index: 'apellido', width: 250, editable: true, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'celular', index: 'celular', width: 250, editable: true,editrules:{number:true,maxValue:999999999 }, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'direccion', index: 'direccion', width: 250, editable: true, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'deuda', index: 'deuda', width: 250, editable: false, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }}
        ],
        rowNum: 200,
        width: 700,
        rowList: [200, 700, 1300],
        pager: '#pGridClientes',
        sortname: 'cedula',
        viewrecords: true,
        sortorder: "asc",
        caption: "Clientes",
        multiselect: false,
        editurl: "ClientesControlador",
    }).jqGrid('navGrid', '#pGridClientes', {
        refresh: true,
        edit: true,
        add: true,
        del: false,
        search: false
    },
    
    {// Antes de enviar a obj->edit(...) se agrega un POST
        modal: false, jqModal: false,
        width: 465,  
    },
            {// Antes de enviar a obj->add(...) se agrega un POST
                modal: false, jqModal: false,
                width: 465,
               
            },
    {modal: false, jqModal: false,
        width: 300,
    
    },
    {multipleSearch: true, multipleGroup: true}
    ).navButtonAdd('#pGridClientes', {
        caption: "",
        title: "Eliminar Cliente",
        buttonicon: "ui-icon ui-icon-trash",
        onClickButton: eliminarCliente,
        position: "last"
    })
}
function eliminarCliente()
{
    var selectedRowId = jqGridClientes.jqGrid('getGridParam', 'selrow');
    var cedula = jqGridClientes.jqGrid('getCell', selectedRowId, 'cedula');
    var deuda = jqGridClientes.jqGrid('getCell', selectedRowId, 'deuda');
    if (selectedRowId == null)
    {
        $("#dialog-selecion").dialog();
    }
    else if (deuda > 0)
    {
        $("#dialog-message-deuda").dialog({
            modal: true,
            height: 150,
            draggable: false,
            buttons: {
                Ok: function () {
                    $(this).dialog("close");
                }
            }
        });
    }
    else {
        $("#dialog-elimiar").dialog({
            resizable: false,
            height: 140,
            modal: true,
            draggable: false,
            buttons: {
                "Eliminar item": function () {
                    $.ajax({
                        data: {oper: "del", cedula: cedula},
                        url: 'ClientesControlador',
                        type: 'POST',
                        success: function (response) {
                            console.log(response);
                        }
                    })
                    jqGridClientes.trigger("reloadGrid");
                    $(this).dialog("close");
                },
                Cancel: function () {
                    $(this).dialog("close");

                }
            }
        });
    }
}




