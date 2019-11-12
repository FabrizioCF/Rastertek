<%-- 
    Document   : index
    Created on : Apr 16, 2019, 3:23:59 PM
    Author     : Fabrizio Cruz
--%>

<%@page import="Model.Tema"%>
<%@page import="Model.Tutorial"%>
<%@page import="java.util.List"%>
<%
    List<Tutorial> listaTutorial = (List<Tutorial>) request.getAttribute("tutoriales");
    String respuestaMail;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - Home</title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body class="Raster-container">
        <%
            if (request.getAttribute("emailMessage") != null) {
                respuestaMail = (String)request.getAttribute("emailMessage");
        %>
        <script>
            alert(<%= respuestaMail %>);
        </script>
        <%
            }
        %>

        <% if (session.getAttribute("nombreUsuario") != null) { %>
        <jsp:include page="templates/navbar_template2.jsp"/>
        <%  } else { %>
        <jsp:include page="templates/navbar_template.jsp"/>
        <%  }%>

        <div class="container">
            <div class="row">
                <%
                    for (Tutorial tut : listaTutorial) {
                %>
                <div class="card border-info my-3 mx-auto tarjeta-tema col-5" >
                    <h4 class="card-header bg-transparent border-info"><%= tut.getNombre()%></h4>
                    <div class="card-body tarjeta-tema">
                        <%
                            int limite = 0;
                            boolean validaTerminaLoopInterior = false;
                            for (Tema tema : tut.getListaTema()) {
                                if (limite < 3) {
                        %>
                        <div class="tema-template" >
                            <a href="CargaIndex?verTutorial=<%=tema.getIdTema()%>" class="temasIndex">
                                <h6 class="mx-auto"><%=tema.getNombre()%></h6>
                                <img src="GetTemaImg?idTema=<%=tema.getIdTema()%>&tipoResponse=1" alt="..." class="mx-4" />
                            </a>
                        </div>
                        <%
                                if (limite == 2) {
                                    validaTerminaLoopInterior = true;
                                }
                            }
                            limite++;
                        %>
                        <%
                            if (validaTerminaLoopInterior) {
                                validaTerminaLoopInterior = false;
                        %>
                    </div>
                    <div class="card-body tarjeta-tema temas-hidden">
                        <%      }
                            if (limite > 3) {%>
                        <div class="tema-template">
                            <a href="CargaIndex?verTutorial=<%=tema.getIdTema()%>" class="temasIndex">
                                <h6 class="mx-auto"><%=tema.getNombre()%></h6>
                                <img src="GetTemaImg?idTema=<%=tema.getIdTema()%>&tipoResponse=1" alt="..." class="mx-4" />
                            </a>
                        </div>
                        <%
                                }
                            }
                        %>
                    </div>
                    <a  class="card-footer bg-transparent border-info py-1 text-right ver-todos">
                        Ver todos
                    </a>
                </div>
                <%
                    }
                %>
            </div>
        </div>

        <jsp:include page="templates/footer_template.jsp"/>
    </body>
</html>
