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
public class Ingresos {

    private int id_producto;
    private int cantidad;
    private double valor;

    public Ingresos() {

    }

    public Ingresos(int id_producto, double valor, int cantidad) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public void insertar() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String sql = "insert into  ingresos (id_producto,valor,cantidad,fecha) values("
                + this.id_producto + ","
                + this.valor + ","
                + this.cantidad + ",now());";

        conexion.s.executeUpdate(sql);
        actualizarCantidad();
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

    public void actualizarCantidad() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String sql = "update productos set cantidad=cantidad+" + this.cantidad + "where id_producto=" + this.id_producto + ";";

        conexion.s.executeUpdate(sql);
        conexion.connection.close();

    }
}
