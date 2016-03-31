/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ambrosio
 */
public class Conexion {
    protected Connection connection;
    protected ResultSet rs;
    protected Statement s;
    protected PreparedStatement ps;

    public Conexion() {
        this.connection = null;
        this.rs = null;
        this.s = null;
        this.ps=null;
    }

    public void conectar() {
        if (this.connection != null) {
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/dbtienda";
        String password = "tienda";
        String user = "tienda";
        try {
            Class.forName("org.postgresql.Driver");

            this.connection = DriverManager.getConnection(url, user, password);
            if(this.connection != null){
                System.out.println("Conectado a la base de datos...");
            }
        } catch (Exception e) {
            System.out.println("Problemas de conexion");
        }
    }
}
