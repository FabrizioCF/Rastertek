/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.DB_Utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
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
        maxFileSize = 1000 * 1000 * 35,
        maxRequestSize = 1000 * 1000 * 35,
        fileSizeThreshold = 1000 * 1000)

public class AddTema extends HttpServlet {

    private static final long serialVersionUID = 1L;
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
        
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement stmt = null;
        
        int idTut = Integer.parseInt(request.getParameter("idTutorial"));
        String nombre = request.getParameter("nombre");
        Part file = request.getPart("imagen");
        InputStream is = file.getInputStream();
        
        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
            con = dS.getConnection();

            stmt = con.prepareCall(DB_Utils.SP_AddTema);
            stmt.setInt(1, idTut);
            stmt.setString(2, nombre);
            stmt.setBlob(3, is);
            System.out.println(stmt.toString());
            rS = stmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        } catch (NamingException ex) {
            System.out.println("ERROR al intentar obtener el DataSource: " + ex.getMessage());
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
        response.sendRedirect("AgregaTema.jsp");
    }
}
