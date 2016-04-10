package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/index.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"../includes/jqGrid/css/ui.jqgrid.css\" >\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"../includes/jqGrid/plugins/ui.multiselect.css\" >\n");
      out.write("        <script src=\"../includes/jqGrid/js/i18n/grid.locale-es.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../includes/jqGrid/js/jquery.jqGrid.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../includes/jquery-2.1.0.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../includes/boostrapv3/css/bootstrap.css\" \n");
      out.write("              <link type=\"text/css\" href=\"../includes/jquery-ui-1.10.4/css/smoothness/jquery-ui-1.10.4.custom.css\" rel=\"stylesheet\" >\n");
      out.write("        <script type=\"text/javascript\" src=\"../includes/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.min.js\"></script>\n");
      out.write("        <title>Bienvenido amdmin</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        <header class=\"col-xs-12 \">\n");
      out.write("            DEPOSITO LA Y\n");
      out.write("        </header>\n");
      out.write("        <nav class=\"col-xs-4\">\n");
      out.write("            <button id=\"btnVerClientes\"  class=\"btn-default\">VerClientes</button>\n");
      out.write("            <button id=\"btnVerProductos\"  class=\"btn-default\">VerProductos</button>\n");
      out.write("\n");
      out.write("        </nav>\n");
      out.write("        <section class=\"col-xs-8\">\n");
      out.write("\n");
      out.write("            <div id=\"Root\">\n");
      out.write("                <div id=\"grid\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <aside></aside>\n");
      out.write("\n");
      out.write("        <footer class=\"col-xs-12 \"> gian carlos figuero</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
