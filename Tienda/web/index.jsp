<%-- 
    Document   : index
    Created on : 06-mar-2016, 22:36:58
    Author     : Ambro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="includes/boostrapv3/css/bootstrap.css" 
              <!--Compruebe que las librerías jquery, jquery ui, jqgrid, etc. se encuentren en ../www/includes/ -->
        	<link href="css/MyProyect/stylesheets/screen.css" media="screen, projection" rel="stylesheet" type="text/css" />
	<link href="css/MyProyect/stylesheets/print.css" media="print" rel="stylesheet" type="text/css" />
        <link href="css/MyProyect/stylesheets/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="includes/jquery-2.1.0.min.js"></script>
        <!--Enseguida se pueden probar otros temas como: redmond o pepper-grinder-->
        <link type="text/css" href="includes/jquery-ui-1.10.4/css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet" >
        <script type="text/javascript" src="includes/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.min.js"></script>

        <link rel="stylesheet" type="text/css" media="screen" href="includes/jqGrid/css/ui.jqgrid.css" >
        <link rel="stylesheet" type="text/css" media="screen" href="includes/jqGrid/plugins/ui.multiselect.css" >
        <script src="includes/jqGrid/js/i18n/grid.locale-es.js" type="text/javascript"></script>
        <script src="includes/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/index.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <header class="col-xs-12">
            TIENDA
        </header>
        <nav class="col-xs-4">
            <button id="btnVerClientes"  class="btn-default">VerClientes</button>
            <button id="btnVerProductos"  class="btn-default">VerProductos</button>
        </nav>
        <section class="col-xs-8">
            <div id="Root">
                <div id="grid">

                </div>
            </div>
        </section>
        <aside></aside>
        <footer class="col-xs-12"> gian carlos figuero</footer>


    </body>
</html>
