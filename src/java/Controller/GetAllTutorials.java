/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Constantes;
import Model.Tutorial;
import Utils.DB_Utils;
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
import javax.sql.DataSource;

/**
 *
 * @author Fabrizio Cruz
 */
public class GetAllTutorials extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Tutorial> tutorials = new ArrayList<Tutorial>();
        InitialContext iC = null;
        Context context = null;
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement stmt = null;

        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
            conn = dS.getConnection();

            stmt = conn.prepareCall(DB_Utils.SP_GET_ALL_TUTORIALS);
            stmt.setInt(1, Constantes.ESTATUS_ACTIVO);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                byte[] imgTutorial = rs.getBytes("imgTutorial");
                int idTut = rs.getInt("idTutorial");

                Tutorial tuts = new Tutorial(idTut, nombre, descripcion, imgTutorial);
                tutorials.add(tuts);
            }
        } catch (NamingException ex) {
            Logger.getLogger("Error al intentar obtener el DataSource: "
                    + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): "
                    + ex.getMessage());
        } catch (Exception e) {
            e.getMessage();
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
        request.setAttribute("tutorials", tutorials);
        response.setContentType("image/jpg");
        
        request.getRequestDispatcher("AdminTutorials.jsp").forward(request, response);
    }
}
