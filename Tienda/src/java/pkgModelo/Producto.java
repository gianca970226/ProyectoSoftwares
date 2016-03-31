/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gian
 */
public class Producto extends Conexion
{

    private int id_producto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double valor;
    private String distribuidor;
    private ResultSet res;

    public Producto()
    {
        super();
        try {
            this.conectar();
            this.s = this.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Producto(int id_producto, String nombre, String descripcion, int cantidad, double valor, String distribuidor)
    {
        super();
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.distribuidor = distribuidor;
        
        this.conectar();
        try {
            this.s = this.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertar()
    {
        String sql="insert into productos values("
                +this.id_producto+",'"+this.nombre+"','"
                +this.descripcion+"',"+this.cantidad+","
                +this.valor+",'"+this.distribuidor+"');";
        try {
            this.s.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public static void main(String[] args)
    {
        Producto p = new Producto(7, "asd", "sqda", 2, 2, "adsd");
        p.insertar();
    }

    public String select()
    {
        int contador = 0;
        String json = "{";
        json += "\"total\":1,\"page\":\"1\",\"records\":1,\"rows\":[";
        int cantidad = 0;

        try {

            this.res = s.executeQuery("SELECT count(*) as con FROM productos");

            while (this.res.next()) {
                cantidad = this.res.getInt("con");
            }
            this.res = s.executeQuery("SELECT * FROM productos");

            while (this.res.next()) {

                if (contador + 1 == cantidad) {
                    json += "{\"id\":" + res.getInt("id_producto") + ",\"cell\":[\""
                            + this.res.getInt("id_producto") + "\",\""
                            + this.res.getString("nombre") + "\",\"" + this.res.getString("descripcion") + "\",\""
                            + this.res.getInt("cantidad") + "\",\"" + this.res.getInt("valor") + "\",\""
                            + this.res.getString("distribuidor") + "\"]}";
                } else {
                     json += "{\"id\":" + res.getInt("id_producto") + ",\"cell\":[\""
                            + this.res.getInt("id_producto") + "\",\""
                            + this.res.getString("nombre") + "\",\"" + this.res.getString("descripcion") + "\",\""
                            + this.res.getInt("cantidad") + "\",\"" + this.res.getInt("valor") + "\",\""
                            + this.res.getString("distribuidor") + "\"]},";

                }
                contador++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        json += "]}";

        return json;

    }

 

}
