<%-- 
    Document   : tutorial
    Created on : Apr 17, 2019, 2:00:45 PM
    Author     : Fabrizio Cruz
--%>

<%@page import="Controller.GetTemaImg"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Utils.DB_Utils"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="Model.Tema"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
    List<Tutorial> listaTutorial = (List<Tutorial>) request.getAttribute("tutoriales");
    String idTemaClick = request.getParameter("verTutorial");
    String nombre = null;
%>

<%@page import="Model.Tutorial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - Tutorial <%=idTemaClick%> </title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body>
        <%
            if (session.getAttribute("nombreUsuario") != null) { %>
        <jsp:include page="templates/navbar_template2.jsp"/>
        <%  } else { %>
        <jsp:include page="templates/navbar_template.jsp"/>
        <%  }%>

        <div class="container-fluid Raster-main">
            <div class="row">
                <div class="col-2 mx-2">
                    <div class="Raster-sidebar">
                        <jsp:include page="templates/breadcrum_template.jsp"/>
                        <ul class="list-group">
                            <%
                                for (Tutorial tut : listaTutorial) {
                            %>
                            <li class="list-group-item d-flex justify-content-between align-items-center
                                Raster-sidebar-tema">
                                <%= tut.getNombre()%>
                                <span class="badge badge-primary badge-pill raster-badge"><%= tut.getListaTema().size()%></span>
                            </li>
                            <ul class="list-group px-3 Raster-sidebar-subtema">
                                <%
                                    for (Tema tem : tut.getListaTema()) {
                                %>
                                <li class="list-group-item d-flex justify-content-between align-items-center py-1 Raster-sidebar-tema" id="<%=tem.getIdTema()%>">
                                    <%= tem.getNombre()%>
                                </li>
                                <%
                                    }
                                %>
                            </ul>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                </div>
                <div class="col-8 my-3">
                    <div class="container Raster-content" id="Tut0102">
                        <% nombre = GetTemaImg.getNombreTema(idTemaClick); %>
                        <h2 id="tema_header"><%=nombre%></h2>
                        <jsp:include page="Tutoriales/Tut0102.jsp"/>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="templates/footer_template.jsp"/>
    </body>
</html>
