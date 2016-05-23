<%-- 
    Document   : admis
    Created on : 10/04/2016, 02:56:02 AM
    Author     : gian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../includes/boostrapv3/css/bootstrap.css" </link>
        <link rel="stylesheet" type="text/css" href="../css/admin.css" </link>
        <!--Enseguida se pueden probar otros temas como: redmond o pepper-grinder-->
        <link type="text/css" href="../includes/jquery-ui-1.10.4/css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet" >
        <link rel="stylesheet" type="text/css" media="screen" href="../includes/jqGrid/css/ui.jqgrid.css" >
        <link rel="stylesheet" type="text/css" media="screen" href="../includes/jqGrid/plugins/ui.multiselect.css" >
        <link rel="icon" type="image/png" href="../imagenes/icono.png" />
    
        <!--Compruebe que las librerías jquery, jquery ui, jqgrid, etc. se encuentren en ../www/includes/ -->

        <script type="text/javascript" src="../includes/jquery-2.1.0.min.js"></script>
        <script type="text/javascript" src="../includes/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.min.js"></script>
        <script src="../includes/jqGrid/js/i18n/grid.locale-es.js" type="text/javascript"></script>
        <script src="../includes/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="../js/home.js"></script>

        <title>Vendedor</title>

    </head>
    <body class="container">
        <header class="col-xs-12 ">
            <img src="../imagenes/header2.png">
        </header>


        <nav class="col-xs-12 ">

            <div id='menuadmin'>
                <input type="button" id="btnConsultarDeuda"  class="myClass1 col-xs-4" value="Deuda">
                <!--  <input  type="button" id="btnVerProductos"  class="myClass1 col-xs-4" value="Productos">-->
            </div>

        </nav>


        <section class="col-xs-12">

            <div id="Root">
                <div id="grid">

                </div>
            </div>


            <div class="form-inline col-xs-6"  id="formBuscar" style="display: none" >
                <div class="form-group col-xs-12">
                    <label style="color: #ffffff" for="cedulaCliente" >CEDULA</label>
                    <input id="cedulaCliente" type="text" class="form-control"
                           placeholder="Introduce tu cedula">
                </div>

                <button type="submit" id="enviar" class="btn btn-default ">Buscar</button>                  
                <br> <br> <br> 
                <div class="form-inline col-xs-12" id="datosCliente" style="display: none">
                    <label class="col-xs-3" style="color: #ffffff">NOMBRE</label>
                    <input  id="nombreCliente" type="text" disabled="false"  class="form-control col-xs-8" >
                    <br><br>
                    <label style="color: #ffffff" class="col-xs-3">DEUDA</label>
                    <input id="deudaCliente" type="text" disabled="false" class="form-control  col-xs-8" >
                    <br> <br> <br> 
                    <div class="col-xs-12">
                        <button type="submit" id="aceptar" class="btn btn-default col-xs-4" >Aceptar</button>
                        <div class="col-xs-2"></div>
                        <button type="submit" id="registarPago" class="btn btn-default col-xs-4"> Pago</button>
                    </div>


                </div>
            </div>



        </section>

        <aside>



        </aside>


        <footer class="col-xs-12 "> gian carlos figuero</footer>
        <!--zona de dialogos-->


        <div id="dialog-registrarPago" hidden="true" title="Registrar pago">
            <p class="validateTips">Registre su valor a cancelar a la deuda</p>
            <p id="aviso" style="color: red" ></p>
            <form>
                <fieldset>
                    <label for="valor">Valor a Pagar</label>
                    <input type="text" name="valor" id="valor" class="text ui-widget-content ui-corner-all">
                    <!-- Allow form submission with keyboard without duplicating the dialog button -->
                    <input type="submit" id="pagar" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
            </form>
        </div>






        <div id="dialog-usuario" hidden="true" title="Registro">
            <p>
                <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
                Este cliente no se encuetra registrado
            </p>

        </div>
        <div id="dialog-camposVacios" hidden="true"  title="Cedula">
            <p>
                <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
                Ingrese cedula para buscar
            </p>

        </div>
        <div id="dialog-valorVacio" hidden="true"  title="Valor">
            <p>
                <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
                Ingrese valor a pagar
            </p>

        </div>

        <div id="dialog-deuda" hidden="true"  title="Deuda">
            <p>
                <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
                Usted no tiene deuda 
            </p>

        </div>





    </body>
</html>
