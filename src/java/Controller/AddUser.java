/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.DB_Utils;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class AddUser extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        /* Obtengo variables */
        String nombre = request.getParameter("nombreUsuario");
        String apellido = "apellido";//request.getParameter("apellidoUsuario");
        String correo = request.getParameter("correoUsuario");
        String contra = request.getParameter("contraUsuario");

        /* Hago la conexión a base de datos */
        InitialContext iC;
        Context context;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;

        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/rastertek");
            con = dS.getConnection();

            statement = con.prepareCall(DB_Utils.SP_ADD_USER);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, correo);
            statement.setString(4, contra);
            rS = statement.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): "
                    + ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger("ERROR al intentar obtener el DataSource: "
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
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): "
                        + ex.getMessage());
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("correoUsuario", correo);
        session.setAttribute("nombreUsuario", nombre);

        /* Redirecciona a otra pagina */
        response.sendRedirect("CargaIndex");
    }
}
