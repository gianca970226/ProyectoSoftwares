/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gian
 */
public class Producto {

    private int id_producto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double valor;
    private String distribuidor;

    public Producto() {

    }

    public Producto(int id_producto, String nombre, String descripcion, int cantidad, double valor, String distribuidor) {

        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.distribuidor = distribuidor;

    }

    public Producto(int id_producto, String nombre, String descripcion, double valor, String distribuidor) {
        super();
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.distribuidor = distribuidor;

    }

    public void insertar() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String sql = "insert into productos values("
                + this.id_producto + ",'" + this.nombre + "','"
                + this.descripcion + "'," + this.cantidad + ","
                + this.valor + ",'" + this.distribuidor + "');";

        conexion.s.executeUpdate(sql);
        conexion.connection.close();

    }

    public String validarid(int id) throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String json = "{\"ok\":";

        String sql = "select count (*) as con from productos where id_producto=" + id;
        conexion.rs = conexion.s.executeQuery(sql);
        int cantidad = 0;
        while (conexion.rs.next()) {
            cantidad = conexion.rs.getInt("con");
        }
        System.out.println("la cantidad es " + cantidad);
        if (cantidad == 0) {
            json += "\"bien\"}";
        } else {
            json += "\"mal\"}";
        }
        conexion.connection.close();
        return json;
    }

    public String select() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        int contador = 0;
        String json = "{";
        json += "\"total\":1,\"page\":\"1\",\"records\":1,\"rows\":[";
        int cantidad = 0;

        conexion.rs = conexion.s.executeQuery("SELECT count(*) as con FROM productos");

        while (conexion.rs.next()) {
            cantidad = conexion.rs.getInt("con");
        }
        conexion.rs = conexion.s.executeQuery("SELECT * FROM productos");

        while (conexion.rs.next()) {

            if (contador + 1 == cantidad) {
                json += "{\"id\":" + conexion.rs.getInt("id_producto") + ",\"cell\":[\""
                        + conexion.rs.getInt("id_producto") + "\",\""
                        + conexion.rs.getString("nombre") + "\",\"" + conexion.rs.getString("descripcion") + "\",\""
                        + conexion.rs.getInt("cantidad") + "\",\"" + conexion.rs.getInt("valor") + "\",\""
                        + conexion.rs.getString("distribuidor") + "\"]}";
            } else {
                json += "{\"id\":" + conexion.rs.getInt("id_producto") + ",\"cell\":[\""
                        + conexion.rs.getInt("id_producto") + "\",\""
                        + conexion.rs.getString("nombre") + "\",\"" + conexion.rs.getString("descripcion") + "\",\""
                        + conexion.rs.getInt("cantidad") + "\",\"" + conexion.rs.getInt("valor") + "\",\""
                        + conexion.rs.getString("distribuidor") + "\"]},";

            }
            contador++;
        }

        json += "]}";
        conexion.connection.close();
        return json;

    }

    public void update(int id) throws SQLException {

        Conexion conexion = conectarBaseDatos();
        String sql = "update productos SET id_producto=" + this.id_producto + ", nombre='" + this.nombre
                + "',descripcion='" + this.descripcion + "',valor=" + this.valor + ",distribuidor='" + this.distribuidor
                + "' where id_producto=" + id;

        conexion.s.executeUpdate(sql);
        conexion.connection.close();
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
