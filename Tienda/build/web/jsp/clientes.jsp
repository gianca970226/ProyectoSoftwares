<%-- 
    Document   : persona.jsp
    Created on : 25/03/2016, 02:32:07 PM
    Author     : gian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/Clientes.js"></script>

    </head>
    <body>
        <table id="gridClientes"></table>
        <div id="pGridClientes"></div>
        <div id="dialog-elimiar" hidden="false" title="Confirmar?">
            <p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>Esta seguro eliminar el cliente?</p>
        </div>
        <div id="dialog-selecion" hidden="false" title="Aviso">
  <p>Selecione fila</p>
</div>
        
            
        </div>
        <div id="dialog-message-deuda" hidden="false"  title="Deuda">
            <p>
                <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
                El cliente tiene deuda pendiente
            </p>
        
            
        </div>
    </body>
</html>