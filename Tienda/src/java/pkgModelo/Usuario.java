/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gian
 */
public class Usuario extends Conexion
{

    private String usuario;
    private String password;
    private String rol;
    private ResultSet res;

    public Usuario()
    {
        super();
        try {
            this.conectar();
            this.s = this.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario(String usuario, String password)
    {
        this.usuario = usuario;
        this.password = password;

        this.conectar();
        try {
            this.s = this.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String IniciarSesion()
    {

        String json = "{\"respuesta\":";
        int bandera = 0;
        try {

            this.res = s.executeQuery("SELECT usuario as user,rol as rol FROM usuarios  "
                    + " WHERE usuario ='" + this.usuario + "' and password ='" + this.password + "';");

            while (this.res.next()) {
                System.out.println("oeoeoeoeoeoeoeoassads");
                json += "\"" + this.res.getString("rol") + "\"}";
                bandera = 1;
                System.out.println("oeoeo");
            }
            if (bandera == 0) {
                System.out.println("SELECT usuario as user FROM usuarios  "
                        + "WHERE usuario='" + this.usuario + ";");
                this.res = s.executeQuery("SELECT usuario as user FROM usuarios  "
                        + "WHERE usuario='" + this.usuario + "';");

                while (this.res.next()) {
                    json += "\"" + "contraseña" + "\"}";
                    bandera = 1;
                   
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bandera == 0) {
            json += "\"" + "noregistrado" + "\"}";

        }
        return json;
    }

}
