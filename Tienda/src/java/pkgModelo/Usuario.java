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
public class Usuario {

    private String usuario;
    private String password;
    private String rol;

    public Usuario() {

    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;

    }

    public String IniciarSesion() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String json = "{\"respuesta\":";
        int bandera = 0;

        conexion.rs = conexion.s.executeQuery("SELECT usuario as user,rol as rol FROM usuarios  "
                + " WHERE usuario ='" + this.usuario + "' and password ='" + this.password + "';");

        while (conexion.rs.next()) {
            System.out.println("oeoeoeoeoeoeoeoassads");
            json += "\"" + conexion.rs.getString("rol") + "\"}";
            bandera = 1;
            System.out.println("oeoeo");
        }
        if (bandera == 0) {
            System.out.println("SELECT usuario as user FROM usuarios  "
                    + "WHERE usuario='" + this.usuario + ";");
            conexion.rs = conexion.s.executeQuery("SELECT usuario as user FROM usuarios  "
                    + "WHERE usuario='" + this.usuario + "';");

            while (conexion.rs.next()) {
                json += "\"" + "contraseña" + "\"}";
                bandera = 1;

            }
        }

        if (bandera == 0) {
            json += "\"" + "noregistrado" + "\"}";

        }
          conexion.connection.close();
        return json;
    }

    public Conexion conectarBaseDatos() {
        Conexion conexion;

        conexion = new Conexion();

        try {

            conexion.conectar();
            conexion.s = conexion.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }

}
