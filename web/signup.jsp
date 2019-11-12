<%-- 
    Document   : login
    Created on : Apr 17, 2019, 3:26:38 PM
    Author     : Fabrizio Cruz
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Constantes"%>
<%@page import="Model.User"%>
<%@page import="java.util.List"%>
<%
    User us = new User();
    List<User> users = new ArrayList<User>();
    users = us.GetAllUsers(Constantes.ESTATUS_TODOS);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - Sign up</title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body class="Raster-login">
        <div class="container">
            <form id="signupForm" method="POST" action="AddUser">
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
                                        <img src="https://img.icons8.com/ios-glyphs/20/000000/person-male.png">
                                    </span>
                                </div>
                                <input type="text" class="form-control"
                                       name="nombreUsuario"
                                       placeholder="Your name" 
                                       aria-label="Name" 
                                       aria-describedby="basic-addon1"
                                       required
                                       pattern=".{6,}" 
                                       title="Debe contener al menos 6 caracteres">
                            </div>
                        </div>
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
                                       name="correoUsuario"
                                       placeholder="Email" 
                                       aria-label="Email" 
                                       aria-describedby="basic-addon1"
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        
                        <div class="input-group mb-3 col-sm-3 ml-auto">
                            <div class="input-group-prepend">
                                <span class="input-group-text" 
                                      id="basic-addon1">
                                    <img src="https://img.icons8.com/metro/20/000000/lock-2.png">
                                </span>
                            </div>
                            <input type="password" class="form-control" 
                                   placeholder="Password"
                                   id="Pass"
                                   aria-label="Password" 
                                   aria-describedby="basic-addon1"
                                   required
                                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" 
                                       title="Debe contener al menos:
    - 1 mayúscula
    - 1 minúscula
    - 1 numero 
    - 6 caracteres">
                        </div>
                        <div class="input-group mb-3 col-sm-3 mr-auto">
                            <div class="input-group-prepend">
                                <span class="input-group-text" 
                                      id="basic-addon1">
                                    <img src="https://img.icons8.com/metro/20/000000/lock-2.png">
                                </span>
                            </div>
                            <input type="password" class="form-control" 
                                   name="contraUsuario"
                                   id="confirmPass"
                                   placeholder="Confirm password" 
                                   aria-label="Confirm Password" 
                                   aria-describedby="basic-addon1"
                                   required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mx-auto">
                            <button class="btn btn-block Raster-btn my-2 
                                    my-sm-0" type="submit">
                                Sign up!
                            </button>
                        </div>
                    </div>
                </div>                
            </form>

            <div class="row">
                <div class="col-sm-3 mx-auto">
                    <hr>
                    <p>Already have an account?</p>
                    <a class="btn btn-block Raster-btn my-2 my-sm-0" 
                            href="login.jsp">
                        Log in!
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
