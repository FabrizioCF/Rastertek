<%-- 
    Document   : login
    Created on : May 3, 2019, 11:04:00 PM
    Author     : Fabrizio Cruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
    String err = null;
    err = "";
    if(request != null) {
        err = (String)request.getAttribute("error");
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - Login</title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body class="Raster-login">
        <% if(err != null && err.equals("error")) { %>
        <script>
            $(document).ready(function(){
                alert("Correo o contraseña incorrectos.");
            });
        </script>
        <% } %>
        <div class="container login">
            <form id="loginForm" method="POST" action="VerifyUser">
                <div class="mx-auto">
                    <div class="form-group row">
                        <a class="col-sm-3 mx-auto" href="index.jsp">
                            <img src="recursos/Logo_v2.PNG" height="70">
                        </a>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mx-auto">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" 
                                          id="basic-addon1">
                                        <img src="https://img.icons8.com/ios/20/000000/secured-letter-filled.png">
                                    </span>
                                </div>
                                <input type="email" class="form-control" 
                                       name="loginCorreo"
                                       placeholder="Email" 
                                       aria-label="Email" 
                                       aria-describedby="basic-addon1"
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mx-auto">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" 
                                          id="basic-addon1">
                                        <img src="https://img.icons8.com/metro/20/000000/lock-2.png">
                                    </span>
                                </div>
                                <input type="password" class="form-control" 
                                       placeholder="Password"
                                       name="loginPass"
                                       aria-label="Password" 
                                       aria-describedby="basic-addon1"
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mx-auto">
                            <button class="btn btn-block Raster-btn my-2 
                                    my-sm-0" type="submit">
                                Enter!
                            </button>
                        </div>
                    </div>
                </div>                
            </form>
            <div class="row">
                <div class="col-sm-3 mx-auto">
                    <hr>
                    <p>Don't have an account?</p>
                    <a class="btn btn-block Raster-btn my-2 my-sm-0" 
                       href="signup.jsp">
                        Register here!
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
