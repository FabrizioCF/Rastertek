/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.DB_Utils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
public class GetTemaImg extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        InitialContext iC = null;
        Context context = null;
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement stmt = null;

        String nombreTut = null;
        byte[] imageBytes = null;
        OutputStream os = null;

        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");
            DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
            conn = dS.getConnection();

            stmt = conn.prepareCall(DB_Utils.SP_GetTemaImg);
            stmt.setInt(1, Integer.parseInt(request.getParameter("idTema")));
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                nombreTut = rs.getString("nombre");
                imageBytes = rs.getBytes("imgTema");
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

        if (request.getParameter("tipoResponse").equalsIgnoreCase("1")) {
            response.setContentType("image/*");
            os = response.getOutputStream();
            os.write(imageBytes);
            os.flush();
            os.close();
        } else if (request.getParameter("tipoResponse").equalsIgnoreCase("0")) {
            PrintWriter writer = response.getWriter();
            writer.print(nombreTut);
        }
    }

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
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * Función que obtiene el nombre del tema especificado.
     * @param idTema Número id del tema
     */
    public static String getNombreTema(String idTema) {
        
        InitialContext iC = null;
        Context context = null;
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement stmt = null;

        String nombreTut = null;

        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");
            DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
            conn = dS.getConnection();

            stmt = conn.prepareCall(DB_Utils.SP_GetTemaImg);
            stmt.setInt(1, Integer.parseInt(idTema));
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                nombreTut = rs.getString("nombre");
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
        
        return nombreTut;
    }

}
