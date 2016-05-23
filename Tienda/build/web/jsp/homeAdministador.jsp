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
        <!--Compruebe que las librerías jquery, jquery ui, jqgrid, etc. se encuentren en ../www/includes/ -->
        <!--Enseguida se pueden probar otros temas como: redmond o pepper-grinder-->
        <link type="text/css" href="../includes/jquery-ui-1.10.4/css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet" >
        <link rel="stylesheet" type="text/css" media="screen" href="../includes/jqGrid/css/ui.jqgrid.css" >
        <link rel="stylesheet" type="text/css" media="screen" href="../includes/jqGrid/plugins/ui.multiselect.css" >
        <link rel="icon" type="image/png" href="../imagenes/icono.png" />
        
        <script type="text/javascript" src="../includes/jquery-2.1.0.min.js"></script>
        <script type="text/javascript" src="../includes/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.min.js"></script>
        <script src="../includes/jqGrid/js/i18n/grid.locale-es.js" type="text/javascript"></script>
        <script src="../includes/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="../js/home.js"></script>

        <title>Bienvenido amdmin</title>
    </head>
    <body class="container">
        <header class="col-xs-12 ">
                      <img src="../imagenes/header2.png">
        </header>
        <nav class="col-xs-12 ">
            <!--  <button id="btnVerClientes"  class="btn-default">VerClientes</button>
              <button id="btnVerProductos"  class="btn-default">VerProductos</button>-->
            <div id='menuadmin'>
                <input type="button" id="btnVerClientes"  class="myClass1 col-xs-4" value="Clientes">
                <input  type="button" id="btnVerProductos"  class="myClass1 col-xs-4" value="Productos">

            </div>

        </nav>
        <section class="col-xs-12">

            <div id="Root">
                <div id="grid">

                </div>
            </div>
        </section>

        <aside>



        </aside>


        <footer class="col-xs-12 "> gian carlos figuero</footer>


    </body>
</html>
