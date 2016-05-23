/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgControlador;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgModelo.Abono;
import pkgModelo.Cliente;


/**
 *
 * @author gian
 */
@WebServlet(name = "ClientesControlador", urlPatterns
        = {
            "/ClientesControlador"
        })
public class ClientesControlador extends HttpServlet {

    String operacion;
    Cliente clientes;

    public ClientesControlador() {
        this.operacion = "";
        this.clientes = new Cliente();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        this.operacion = request.getParameter("oper");

        switch (this.operacion) {
            case "1":
                response.getWriter().print(this.clientes.select());
                break;
            case "del": 
                this.clientes.delete(Integer.parseInt(request.getParameter("cedula")));
                break;
            
            case "edit": 
                this.clientes.setCedula(Integer.parseInt(request.getParameter("cedula")));
                this.clientes.setNombre(request.getParameter("nombre"));
                this.clientes.setApellido(request.getParameter("apellido"));
                this.clientes.setCelular(Long.parseLong((request.getParameter("celular"))));
                this.clientes.setDireccion(request.getParameter("direccion"));
                this.clientes.update(Integer.parseInt(request.getParameter("id")));
                break;
           
            case "add":
                this.clientes = new Cliente(Integer.parseInt(request.getParameter("cedula")), request.getParameter("nombre"),
                        request.getParameter("apellido"), Long.parseLong(request.getParameter("celular")),
                        request.getParameter("direccion"), 0);
                this.clientes.insertar();
                break;
            case "validar":

                response.getWriter().print(this.clientes.validarCedula(Integer.parseInt(request.getParameter("cedula"))));
                break;
            case "buscarCliente":

                response.getWriter().print(this.clientes.buscarCliente(Integer.parseInt(request.getParameter("cedula"))));
                break;
            case "abonos":
                Abono ingreso = new Abono(Integer.parseInt(request.getParameter("id_cliente")), Double.parseDouble(request.getParameter("valor")));
                ingreso.insertar();
                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
