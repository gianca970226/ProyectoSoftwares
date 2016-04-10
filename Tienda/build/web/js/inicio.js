$(function ()
{

    //para buscar el usuario y la clave
    $("#Enviar").button().on("click", function (event)
    {
       
        usuario = document.getElementById("user").value;
        clave = document.getElementById("pass").value;
        if (usuario != "" && clave != "")
        {
            $.ajax({
                data: {oper:"val",user: usuario, pass: clave},
                url: 'UsuariosControlador',
                type: 'POST',
                success: function (response) {

                    if ($.parseJSON(response).respuesta == "admin") {

                       window.location = 'jsp/admin.jsp';
                    }
                    else if ($.parseJSON(response).respuesta == "vendedor") {

                        window.location = 'vista/Autor.html';
                    }

                    else if ($.parseJSON(response).respuesta == "cliente") {

                       window.location = 'vista/Evaluador.html';
                    }

                    else if ($.parseJSON(response).respuesta =="contraseña") {

                        $("#aviso").text("Contraseña invalida");
                    }

                    else if ($.parseJSON(response).respuesta == "noregistrado") {

                        $("#aviso").text("Usuario no registrado");
                    }
                    else {
                        alert("A");
                    }
                }
            }
            )
        }
        else {
              $("#aviso").text("Campos incompletos");
        }




    }
    )






});

