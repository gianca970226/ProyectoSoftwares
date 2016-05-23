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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgModelo.Ingresos;
import pkgModelo.Producto;

/**
 *
 * @author gian
 */
public class ProductosControlador extends HttpServlet {

    String operacion;
    Producto producto;

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
        this.operacion = "";

        this.producto = new Producto();

        this.operacion = request.getParameter("oper");
        switch (this.operacion) {
            case "1":
                response.getWriter().print(this.producto.select());
                break;
            case "add":
                this.producto = new Producto(Integer.parseInt(request.getParameter("id_producto")), request.getParameter("nombre"),
                        request.getParameter("descripcion"), 0,
                        Double.parseDouble(request.getParameter("valor")), request.getParameter("distribuidor"));
                this.producto.insertar();
                break;
            case "edit":
                System.out.println("oahshadiasdhiasdh");
                this.producto = new Producto(Integer.parseInt(request.getParameter("id_producto")),
                        request.getParameter("nombre"), request.getParameter("descripcion"),
                        Double.parseDouble(request.getParameter("valor")),
                        request.getParameter("distribuidor"));

                this.producto.update(Integer.parseInt(request.getParameter("id")));

                break;

            case "ingresos":
                Ingresos ingreso = new Ingresos(Integer.parseInt(request.getParameter("id")),  Double.parseDouble(request.getParameter("precio")), Integer.parseInt(request.getParameter("cantidad")));
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
            Logger.getLogger(ProductosControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductosControlador.class.getName()).log(Level.SEVERE, null, ex);
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
