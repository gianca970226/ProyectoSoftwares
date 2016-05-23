<%-- 
    Document   : productos
    Created on : 28/03/2016, 10:35:37 PM
    Author     : gian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../js/Productos.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <table id="gridProductos"></table>
        <div id="pgridProductos"></div>
        <div id="dialog-selecion" hidden="false" title="Aviso">
            <p>Selecione fila</p>
        </div>
        <div id="dialog-adicionar" class="col-xs-12" hidden="false" title="Adicionar cantidad producto nuevo">
            <p id="error"> </p>
            <label class="col-xs-5">Nombre</label>
            <input  class="col-xs-7" id="nombreProducto" type="text" disabled="true" >

            <label class="col-xs-5">Precio </label>

            <input class="col-xs-7" id="precioProducto" type="text"  >

            <label class="col-xs-5 "  >Ingrese cantidad </label>

            <input class="col-xs-7"  placeholder="ingrese cantidad"id="cantidadProducto" type="text"  >
            
            

        </div>


    </body>
</html>
