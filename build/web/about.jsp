<%-- 
    Document   : about
    Created on : Apr 17, 2019, 2:12:37 PM
    Author     : Fabrizio Cruz
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Tema"%>
<%@page import="Model.Tutorial"%>

<%
    List<Tutorial> listaTutorial = (List<Tutorial>) request.getAttribute("tutoriales");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - About us</title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body>
        <%
            if (session.getAttribute("nombreUsuario") != null) { %>
        <jsp:include page="templates/navbar_template2.jsp"/>
        <%  } else { %>
        <jsp:include page="templates/navbar_template.jsp"/>
        <%  } %>

        <div class="container-fluid Raster-main">
            <div class="row">
                <div class="col-sm-2 mx-2">
                    <div class="Raster-sidebar">
                        <jsp:include page="templates/breadcrum_template.jsp"/>
                        <ul class="list-group">
                            <%
                                for (Tutorial tut : listaTutorial) {
                            %>
                            <li class="list-group-item d-flex justify-content-between align-items-center
                                Raster-sidebar-tema">
                                <%= tut.getNombre()%>
                                <span class="badge badge-primary badge-pill"><%= tut.getListaTema().size()%></span>
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

                <div class="col-sm-8 Raster-content">
                    <jsp:include page="templates/breadcrum_template.jsp"/>
                    <h2>About us</h2>

                    <p>The purpose of this website is to provide tutorials for 
                        graphics programming using DirectX 10, DirectX 11, 
                        and DirectX 12. </p>

                    <p>The DirectX tutorials are written using C++ with HLSL 
                        and use shader version 4.0, 5.0, and 5.1. </p>

                    <p>I also have tutorials for different programming 
                        subjects that interest me. </p>

                    <p>To begin click on the Tutorials link down below. </p>

                    <p> I have created this website as a hobby interest. </p>

                    <p>I enjoy graphics programming and recently had a renewed interest 
                        with the release of DirectX 10. </p>

                    <p>I found there were limited resources for information on these topics 
                        so I decided to contribute my own tutorials to the information out 
                        there.</p>

                    <p>There will also be some other random tutorials for programming 
                        other things that interest me that I will tie into the DirectX 
                        tutorials. </p>

                    <p>I hope you enjoy the site and find a good use for the information 
                        that I provide here.</p>

                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Sed mattis venenatis ante, nec tempus lectus scelerisque non. 
                        Mauris nec metus eu ipsum aliquam bibendum. 
                        Mauris egestas lorem sed quam interdum, hendrerit efficitur 
                        tortor varius. Cras sodales magna id massa tristique, sed 
                        sagittis risus dictum. In ultricies, nibh sed mattis mattis, 
                        diam lectus efficitur odio, non ultricies quam mi vel felis. 
                        Nullam egestas consequat bibendum. Sed efficitur urna turpis, 
                        in tempor leo pretium ac. Praesent vel velit faucibus, sodales 
                        lectus ac, pellentesque leo. Cras sollicitudin laoreet est, et 
                        efficitur tellus sollicitudin sit amet. Cras congue condimentum 
                        magna, vitae vulputate velit convallis condimentum. In molestie 
                        massa nunc, eu lacinia justo semper id.</p>

                    <p>Mauris pellentesque, dolor nec commodo consectetur, 
                        felis ante dignissim risus, a eleifend risus arcu in tellus. 
                        Phasellus auctor viverra quam sit amet imperdiet. Duis porta 
                        posuere ornare. Donec gravida mauris id mi rutrum vehicula. 
                        Nunc lacus arcu, porta faucibus justo quis, finibus sagittis 
                        mauris. Sed ut faucibus quam. Pellentesque non magna orci. 
                        Ut commodo elit non nunc elementum vehicula. Etiam at sem nisl. 
                        Integer sollicitudin arcu sed ante mattis, at vulputate tellus 
                        ultricies. </p>
                </div>
            </div>
        </div>

        <jsp:include page="templates/footer_template.jsp"/>
    </body>
</html>
