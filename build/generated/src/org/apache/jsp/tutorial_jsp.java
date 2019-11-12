package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Tema;
import java.util.ArrayList;
import java.util.List;
import Model.Tutorial;

public final class tutorial_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    List<Tutorial> listaTutorial = (List<Tutorial>) request.getAttribute("tutoriales");
    String idTutorialClick = request.getParameter("verTutorial");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Rastertek - Tutorial ");
      out.print(idTutorialClick);
      out.write(" </title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "templates/Metadata_Gral.jsp", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if (session.getAttribute("nombreUsuario") != null) { 
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "templates/navbar_template2.jsp", out, false);
      out.write("\n");
      out.write("        ");
  } else { 
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "templates/navbar_template.jsp", out, false);
      out.write("\n");
      out.write("        ");
  }
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid Raster-main\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-2 mx-2\">\n");
      out.write("                    <div class=\"Raster-sidebar\">\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "templates/breadcrum_template.jsp", out, false);
      out.write("\n");
      out.write("                        <ul class=\"list-group\">\n");
      out.write("                            ");

                                for (Tutorial tut : listaTutorial) {
                            
      out.write("\n");
      out.write("                            <li class=\"list-group-item d-flex justify-content-between align-items-center\n");
      out.write("                                Raster-sidebar-tema\">\n");
      out.write("                                ");
      out.print( tut.getNombre());
      out.write("\n");
      out.write("                                <span class=\"badge badge-primary badge-pill\">");
      out.print( tut.getListaTema().size());
      out.write("</span>\n");
      out.write("                            </li>\n");
      out.write("                            <ul class=\"list-group px-3 Raster-sidebar-subtema\">\n");
      out.write("                                ");

                                    for (Tema tem : tut.getListaTema()) {
                                
      out.write("\n");
      out.write("                                <li class=\"list-group-item d-flex justify-content-between align-items-center py-1 Raster-sidebar-tema\" id=\"");
      out.print(tem.getIdTema());
      out.write("\">\n");
      out.write("                                    ");
      out.print( tem.getNombre());
      out.write("\n");
      out.write("                                </li>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-8 my-3\">\n");
      out.write("                    <div class=\"container Raster-content\" id=\"Tut0102\">\n");
      out.write("                        <h2>Tutorial 2: Creating a Framework and Window </h2>\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Tutoriales/Tut0102.jsp", out, false);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "templates/footer_template.jsp", out, false);
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
