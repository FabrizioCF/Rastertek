<%-- 
    Document   : AdminTutorials
    Created on : May 4, 2019, 1:18:52 PM
    Author     : Fabrizio Cruz
--%>

<%@page import="sun.net.www.content.image.jpeg"%>
<%@page import="java.util.List"%>
<%@page import="Model.Tutorial"%>
<%
    List<Tutorial> tuts = (List<Tutorial>) request.getAttribute("tutorials");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - Administration</title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body class="Raster-login">
        <div class="container">
            <a href="AgregaTutorial.jsp" class="btn btn-primary mx-auto my-5">
                Agregar nuevo tutorial
            </a>

            <div class="row">
                <%
                    for (Tutorial tut : tuts) {
                        System.out.println(tut.getImgTutorial());
                %>
                <div class="card col-sm-4 mx-1" style="width: 18rem;">
                    <img src="data:image/jpeg;base64,
                         GetImageStream?image=<%= tut.getImgTutorial()%>" 
                         class="card-img-top" 
                         alt="...">
                    <div class="card-body">
                        <h5 class="card-title">
                            <%= tut.getNombre()%>
                        </h5>
                        <p class="card-text">
                            <%= tut.getDescripcion()%>
                        </p>
                        <a href="AddTema?idTut=<%= tut.getIdTutorial()%>" 
                           class="btn btn-primary">Agregar temas</a>
                    </div>
                </div>            
                <% }%>
            </div>

        </div>
    </body>
</html>
