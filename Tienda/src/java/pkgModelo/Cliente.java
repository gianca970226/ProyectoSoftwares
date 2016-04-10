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

import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

/**
 *
 * @author Ambro
 */
public class Cliente extends Conexion

{

    private int cedula;
    private String nombre;
    private String apellido;
    private int celular;
    private String direccion;
    private int deuda;
    private ResultSet res;

    public Cliente()
    {
        super();
        try {
            this.conectar();
            this.s = this.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente(int cedula, String nombre, String apellido, int celular, String direccion, int deuda)
    {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.direccion = direccion;
        this.deuda = deuda;
        this.conectar();
    }

    public void delete(int cedula) throws SQLException
    {

        s.executeUpdate("delete  FROM clientes where cedula=" + cedula);
    }

    public String select()
    {

        int contador = 0;
        String json = "{";
        json += "\"total\":1,\"page\":\"1\",\"records\":1,\"rows\":[";
        int cantidad = 0;
        LinkedList<String> lista2 = new LinkedList<>();

        try {

            this.res = s.executeQuery("SELECT count(*) as con FROM clientes");

            while (this.res.next()) {
                cantidad = this.res.getInt("con");
            }
            this.res = s.executeQuery("SELECT * FROM clientes");

            while (this.res.next()) {

                if (contador + 1 == cantidad) {
                    json += "{\"id\":" + res.getInt("cedula") + ",\"cell\":[\""
                            + this.res.getInt("cedula") + "\",\"" + this.res.getString("nombre") + "\",\""
                            + this.res.getString("apellido") + "\",\"" + this.res.getString("celular") + "\",\""
                            + this.res.getString("direccion") + "\",\"" + this.res.getString("deuda") + "\"]}";
                } else {
                    json += "{\"id\":" + res.getInt("cedula") + ",\"cell\":[\""
                            + this.res.getInt("cedula") + "\",\"" + this.res.getString("nombre") + "\",\""
                            + this.res.getString("apellido") + "\",\"" + this.res.getString("celular") + "\",\""
                            + this.res.getString("direccion") + "\",\"" + this.res.getString("deuda") + "\"]},";

                }
                contador++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        json += "]}";

        return json;

    }

   
          public static void main(String[] args)
    {
        Producto p = new Producto(2, "asd", "sqda", 2, 2, "adsd");
        p.insertar();
        int a;
        
    }
    

    public void update(int id)
    {
        String sql = "update clientes SET nombre='" + this.nombre
                + "',apellido='" + this.apellido + "',celular="
                + this.celular + ",direccion='" + this.direccion
                + "' where cedula=" + id;

        try {
            System.out.println(sql);

            s.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public void setCelular(int celular)
    {
        this.celular = celular;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

  

}
