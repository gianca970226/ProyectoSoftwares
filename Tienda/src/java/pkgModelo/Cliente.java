/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ambro
 */
public class Cliente {

    private int cedula;
    private String nombre;
    private String apellido;
    private Long celular;
    private String direccion;
    private int deuda;

    public Cliente() {

    }

    public Cliente(int cedula, String nombre, String apellido, Long celular, String direccion, int deuda) throws SQLException {

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.direccion = direccion;
        this.deuda = deuda;

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

    public String buscarCliente(int cedula) throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String json = "{";
        try {
            conexion.rs = conexion.s.executeQuery("SELECT * FROM clientes where cedula=" + cedula);

            while (conexion.rs.next()) {

                json += "\"cedula\":\"" + conexion.rs.getInt("cedula") + "\",\"nombre\":\"" + conexion.rs.getString("nombre") + "\","
                        + "\"deuda\":\"" + conexion.rs.getString("deuda") + "\"}";

            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        conexion.connection.close();
        return json;
    }

    public String validarCedula(int cedula) throws SQLException {
        Conexion conexion = conectarBaseDatos();

        String json = "{\"ok\":";
        String sql = "select count (*) as con from clientes where cedula=" + cedula;
        conexion.rs = conexion.s.executeQuery(sql);
        int cantidad = 0;
        while (conexion.rs.next()) {
            cantidad = conexion.rs.getInt("con");
        }
        if (cantidad == 0) {
            json += "\"bien\"}";
        } else {
            json += "\"mal\"}";
        }
        conexion.connection.close();
        return json;
    }

    public void delete(int cedula) throws SQLException {
        Conexion conexion = conectarBaseDatos();
        conexion.s.executeUpdate("delete  FROM usuarios where cedula=" + cedula);
        conexion.s.executeUpdate("delete  FROM clientes where cedula=" + cedula);
        conexion.connection.close();
    }

    public void insertar() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String sql = "insert into clientes values("
                + this.cedula + ",'" + this.nombre + "','"
                + this.apellido + "'," + this.celular + ",'"
                + this.direccion + "'," + this.deuda + ");";

        System.out.println(sql);
        conexion.s.executeUpdate(sql);

        sql = "";
        sql = sql + "insert into usuarios values (" + this.cedula + ","
                + this.cedula + ",'cliente'," + this.cedula + ")";
        try {
            System.out.println(sql);
            conexion.s.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        conexion.connection.close();
    }

    public String select() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        int contador = 0;
        String json = "{";
        json += "\"total\":1,\"page\":\"1\",\"records\":1,\"rows\":[";
        int cantidad = 0;
        LinkedList<String> lista2 = new LinkedList<>();
        conexion.rs = conexion.s.executeQuery("SELECT count(*) as con FROM clientes");
        while (conexion.rs.next()) {
            cantidad = conexion.rs.getInt("con");
        }
        conexion.rs = conexion.s.executeQuery("SELECT * FROM clientes");

        while (conexion.rs.next()) {

            if (contador + 1 == cantidad) {
                json += "{\"id\":" + conexion.rs.getInt("cedula") + ",\"cell\":[\""
                        + conexion.rs.getInt("cedula") + "\",\"" + conexion.rs.getString("nombre") + "\",\""
                        + conexion.rs.getString("apellido") + "\",\"" + conexion.rs.getString("celular") + "\",\""
                        + conexion.rs.getString("direccion") + "\",\"" + conexion.rs.getString("deuda") + "\"]}";
            } else {
                json += "{\"id\":" + conexion.rs.getInt("cedula") + ",\"cell\":[\""
                        + conexion.rs.getInt("cedula") + "\",\"" + conexion.rs.getString("nombre") + "\",\""
                        + conexion.rs.getString("apellido") + "\",\"" + conexion.rs.getString("celular") + "\",\""
                        + conexion.rs.getString("direccion") + "\",\"" + conexion.rs.getString("deuda") + "\"]},";

            }
            contador++;
        }

        json += "]}";
        conexion.connection.close();
        return json;

    }

    public void update(int id) throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String sql = "update clientes SET cedula=" + this.cedula + ", nombre='" + this.nombre
                + "',apellido='" + this.apellido + "',celular="
                + this.celular + ",direccion='" + this.direccion
                + "' where cedula=" + id;
        System.out.println(sql);
        conexion.s.executeUpdate(sql);
        conexion.connection.close();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

}
