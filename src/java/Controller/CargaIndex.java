/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tema;
import Model.Tutorial;
import Utils.*;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Fabrizio Cruz
 */
public class CargaIndex extends HttpServlet {

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

        HttpSession session = request.getSession();

        InitialContext iC;
        Context context;
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement stmt = null;

        List<Tutorial> listaTutorial = new ArrayList<>();

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

            stmt.clearBatch();

            for (Tutorial tut : listaTutorial) {
                stmt = conn.prepareCall(DB_Utils.SP_GetTemasTutorial);
                stmt.setInt(1, tut.getIdTutorial());
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("idTema");
                    String nombre = rs.getString("nombre");

                    Tema tema = new Tema(id, tut.getIdTutorial(), nombre);
                    tut.getListaTema().add(tema);
                }

                stmt.clearBatch();
            }

            if (!session.isNew() && session.getAttribute("nombreUsuario") != null) {
                stmt = conn.prepareCall(DB_Utils.SP_GET_LAST_TUTORIAL);
                stmt.setString(1, session.getAttribute("correoUsuario").toString());
                System.out.println(stmt.toString());
                rs = stmt.executeQuery();

                session.setAttribute("ultimoTut", rs.getInt("ultimoTutorial"));
                session.setAttribute("ultimoTema", rs.getInt("ultimoTema"));
            } else {
                session.setAttribute("ultimoTut", "");
                session.setAttribute("ultimoTema", "");
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

        request.setAttribute("tutoriales", listaTutorial);
        
        if (request.getParameter("verTutorial") != null) {
            request.getRequestDispatcher("tutorial.jsp").forward(request, response);
        } else if (request.getParameter("verAbout") != null) {
            request.getRequestDispatcher("about.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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

}
