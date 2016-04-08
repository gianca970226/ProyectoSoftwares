/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    crearGridProductos();
});
function crearGridProductos() {

    jqGridClientes = jQuery('#gridProductos').jqGrid({
        url: 'ProductosControlador',
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
            {name: 'nombre', index: 'nombre', width: 250, editable: true, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'descripcion', index: 'descripcion', width: 250, editable: true, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'cantidad', index: 'cantidad', width: 250, editable: true, editrules: {number: true, maxValue: 10}, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'valor', index: 'valor', width: 250, editable: true, editrules: {number: true, maxValue: 10}, editoptions: {size: 44,
                    dataInit: function (elemento) {
                        $(elemento).width(282)
                    }
                }},
            {name: 'distribuidor', index: 'distribuidor', width: 250, editable: true, editrules: {number: false, }, editoptions: {size: 44,
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
        editurl: "ProductosControlador",
    }).jqGrid('navGrid', '#pgridProductos', {
        refresh: true,
        edit: true,
        add: true,
        del: true,
        search: false
    },
    {// Antes de enviar a obj->edit(...) se agrega un POST
        modal: false, jqModal: false,
        width: 465,
    },
            {// Antes de enviar a obj->add(...) se agrega un POST
                modal: false, jqModal: false,
                width: 465,
                beforeSubmit: function ()
                {
                    ban = 0;

                    var rows = jQuery("#gridProductos").jqGrid('getRowData');
                    for (var i = 0; i < rows.length; i++) {
                        var row = rows[i];
                        console.log(row['id_producto']);
                        if (row['id_producto'] == $("#id_producto").val())
                        {
                            ban = 1;
                            break;
                        }

                    }
                    if (ban == 1) {
                        return [false, "El id del producto ya existe", ""];
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
            {multipleSearch: true, multipleGroup: true}
    )
}
