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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="includes/boostrapv3/css/bootstrap.css" 
              <!--Compruebe que las librerías jquery, jquery ui, jqgrid, etc. se encuentren en ../www/includes/ -->
              <link rel="stylesheet" type="text/css" href="css/estilos.css" >

        <!--Enseguida se pueden probar otros temas como: redmond o pepper-grinder-->
        <link type="text/css" href="includes/jquery-ui-1.10.4/css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet" >
        <link href="includes/boostrapv3/css/signin.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        
        
        <script type="text/javascript" src="includes/jquery-2.1.0.min.js"></script>
        <script type="text/javascript" src="includes/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.min.js"></script>
        <script type="text/javascript"src="js/index.js"></script>


        <title>Deposito la ye</title>
    </head>
    <body class="container">

        <!--     <nav class="col-xs-12">
                 <button id="btnVerClientes"  class="btn-default">VerClientes</button>
                 <button id="btnVerProductos"  class="btn-default">VerProductos</button>
          <div id="Root">
                <div id="grid">

                </div>
            </div>
             </nav>-->
        <section class="col-xs-12 ">

            <div id="cuadro" class="form-signin">
                <div id="sub" >
                    <h3 class="h3" align="center" >Deposito la ye</h3>
                    <p style="color: #8A959E; font-size: 14px" align="center"> BIENVENIDO, INGRESA TU CUENTA</p>

                </div>
                <br><br><br>
                <p id="aviso" ></p>
                <input type="text" id="user" class="user form-control" name="user" placeholder="Usuario" required autofocus pmbx_context="5A6224EE-1847-473D-83E8-32838FB5D5FB"  style="background-color:transparent;color: #000">

                <br><br>
                <input type="password" id="pass" class="pass form-control" name="pass" placeholder="Password" required pmbx_context="5BBFEA10-ED55-4FB3-91F2-40027E5FFAE5"  style="background-color:transparent; color: #000" >
                <br>
                <button  id="Enviar2" >Ingresar</button>


            </div>  <!----fin de container---->

        </section>

        <aside></aside>

    </body>
</html>
