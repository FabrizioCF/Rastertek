<%-- 
    Document   : AgregaTema
    Created on : Jun 7, 2019, 12:00:35 AM
    Author     : Fabrizio Cruz
--%>

<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="Utils.*"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Tutorial"%>
<%@page import="java.util.List"%>
<%
    InitialContext iC = null;
    Context context = null;
    Connection conn = null;
    ResultSet rs = null;
    CallableStatement stmt = null;

    List<Tutorial> listaTutorial = new ArrayList<Tutorial>();

    try {
        iC = new InitialContext();
        context = (Context) iC.lookup("java:comp/env");
        DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
        conn = dS.getConnection();

        stmt = conn.prepareCall(DB_Utils.SP_GET_ALL_TUTORIALS);
        stmt.setInt(1, Utils.Activo);
        System.out.println(stmt.toString());
        rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("idTutorial");
            String nombre = rs.getString("nombre");
            String descri = rs.getString("descripcion");

            Tutorial tut = new Tutorial(id, nombre, descri);
            listaTutorial.add(tut);
        }
    } catch (SQLException ex) {
        Logger.getLogger("SQL Error: " + ex.getMessage());
    } catch (NamingException ex) {
        Logger.getLogger("DataSource Error: ",
                "Mensaje: " + ex.getMessage());
    } catch (Exception ex) {
        Logger.getLogger("Error: ", ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): "
                    + ex.getMessage());
        } catch (Exception e) {
            e.getMessage();
        }
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastertek - Administracion</title>
        <jsp:include page="templates/Metadata_Gral.jsp"/>
    </head>
    <body>
        <div class="container">
            <form id="agregaTutorial" method="POST" action="AddTema" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Selecciona Tutorial</label>
                    <select class="form-control" name="idTutorial" id="exampleFormControlSelect1">
                        <% for (Tutorial tut : listaTutorial) {%>
                        <option value="<%= tut.getIdTutorial()%>"><%= tut.getNombre()%></option>
                        <% }%>
                    </select>
                </div>
                <div class="form-group row">    
                    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Titulo</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control form-control-sm" name="nombre" id="colFormLabelSm" placeholder="Nombre">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="input-group mb-3">
                        <label for="colFormLabelSm" class="col-sm-2  col-form-label col-form-label-sm">Imagen</label>
                        <div class="input-group mb-3 col-sm-10">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="imagenTutorial" name="imagen">
                                <label class="custom-file-label" for="imagenTutorial" id="id_imagenTutorial" aria-describedby="inputGroupFileAddon02">
                                    Choose file
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-block Raster-btn my-2 my-sm-0" type="submit">
                    Agregar
                </button>
            </form>
        </div>
    </body>
</html>
