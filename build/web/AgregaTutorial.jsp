<%-- 
    Document   : AgregaTutorial
    Created on : May 4, 2019, 2:07:00 PM
    Author     : Fabrizio Cruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - Administracion</title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body class="Raster-login">
        <div class="container">
            <form id="agregaTutorial" method="POST" action="AddTutorial"
                  enctype="multipart/form-data">
                <div class="form-group row">    
                    <label for="colFormLabelSm" class="col-sm-2 col-form-label 
                           col-form-label-sm">Title</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control form-control-sm"
                               name="titulo"
                               id="colFormLabelSm" 
                               placeholder="Título">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="colFormLabelSm" class="col-sm-2 col-form-label 
                           col-form-label-sm">Description</label>
                    <div class="form-group col-sm-10">
                        <textarea class="form-control" 
                                  name="descripcion"
                                  id="exampleFormControlTextarea1" 
                                  rows="3"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="input-group mb-3">
                        <label for="colFormLabelSm" class="col-sm-2 
                               col-form-label col-form-label-sm">Image</label>
                        <div class="input-group mb-3 col-sm-10">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" 
                                       id="imagenTutorial"
                                       name="imagen">
                                <label class="custom-file-label" 
                                       for="imagenTutorial"
                                       id="id_imagenTutorial"
                                       aria-describedby="inputGroupFileAddon02">
                                    Choose file</label>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-block Raster-btn my-2 
                        my-sm-0" type="submit">
                    Register
                </button>
            </form>
        </div>
    </body>
</html>
