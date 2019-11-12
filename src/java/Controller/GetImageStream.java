/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.DB_Utils;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Fabrizio Cruz
 */
public class GetImageStream extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InitialContext iC = null;
        Context context = null;
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement stmt = null;
        byte[] imageBytes = null;
        OutputStream os = null;

        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");
            DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
            conn = dS.getConnection();
            
            stmt = conn.prepareCall(DB_Utils.SP_GetTutorialImg);
            stmt.setInt(1, Integer.parseInt(request.getParameter("idTutorial")));
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                imageBytes = rs.getBytes("imgTutorial");
            }
            
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getErrorCode() + ex.getMessage());
        } catch (NamingException ex) {
            System.out.println("DataSource Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
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
                System.out.println("ERROR (" + ex.getErrorCode() + "): "
                        + ex.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        response.setContentType("image/*");
        os = response.getOutputStream();
        os.write(imageBytes);
        os.flush();
        os.close();
    }
}
