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
public class Abono {

    private int id_cliente;
    private double valor;

    public Abono() {

    }

    public Abono(int id_cliente, double valor) {
        this.id_cliente = id_cliente;
        this.valor = valor;
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

    public void insertar() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String sql = "insert into  abonos (id_cliente,valor,fecha) values("
                + this.id_cliente + ","
                + this.valor + ",now());";

        System.out.println(sql);

        conexion.s.executeUpdate(sql);

        actualizarCantidad();
        conexion.connection.close();
    }

    public void actualizarCantidad() throws SQLException {
        Conexion conexion = conectarBaseDatos();
        String sql = "update clientes set deuda=deuda-" + this.valor + " where cedula=" + this.id_cliente + ";";
        System.out.println(sql);

        conexion.s.executeUpdate(sql);
          conexion.connection.close();
    }

}
