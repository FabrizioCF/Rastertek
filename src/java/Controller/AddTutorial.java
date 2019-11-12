/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Constantes;
import Utils.DB_Utils;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 *
 * @author Fabrizio Cruz
 */

@MultipartConfig(
        maxFileSize = 1000*1000*5, 
        maxRequestSize = 1000*1000*25, 
        fileSizeThreshold = 1000*1000)
public class AddTutorial extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Obtengo variables */
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        Part file = request.getPart("imagen");
        
        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + Constantes.RUTE_USER_IMAGE);
        if(!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        String contentType = file.getContentType();
        String nameImage = file.getName() + System.currentTimeMillis() + 
                DB_Utils.GetExtension(contentType);
        file.write(path + nameImage);
        

        /* Hago la conexión a base de datos */
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;

        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
            con = dS.getConnection();

            statement = con.prepareCall(DB_Utils.SP_ADD_TUTORIAL);
            statement.setString(1, titulo);
            statement.setString(2, descripcion);
            statement.setBlob(3, file.getInputStream());
            System.out.println(statement.toString());
            rS = statement.executeQuery();

        } catch (SQLException ex) {
            System.out.println("ERROR (" + ex.getErrorCode() + "): "
                    + ex.getMessage());
        } catch (NamingException ex) {
            System.out.println("ERROR al intentar obtener el DataSource: "
                    + ex.getMessage());
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR (" + ex.getErrorCode() + "): "
                        + ex.getMessage());
            }
        }
        response.sendRedirect("GetAllTutorials");
    }
}
