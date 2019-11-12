/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
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
public class VerifyUser extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("loginCorreo");
        String contra = request.getParameter("loginPass");
        int id = 0;
        User usuario = new User();

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

            statement = con.prepareCall(DB_Utils.FN_VERIFY_USER);
            statement.setString(1, correo);
            statement.setString(2, contra);
            System.out.println(statement.toString());
            rS = statement.executeQuery();

            while (rS.next()) {
                id = rS.getInt("id");
            }

            statement.clearBatch();

            if (id != 0) {
                statement = con.prepareCall(DB_Utils.SP_ConsultaUsuario);
                statement.setInt(1, id);
                System.out.println(statement.toString());
                rS = statement.executeQuery();
                
                while (rS.next()) {
                    String nombre = rS.getString("nombreUsuario");
                    int tut = rS.getInt("ultimoTutorial");
                    int tem = rS.getInt("ultimoTema");
                    
                    usuario.setIdUsuario(id);
                    usuario.setNombreUsuario(nombre);
                    usuario.setCorreo(correo);
                    usuario.setUltimoTutorial(tut);
                    usuario.setUltimoTema(tem);
                    
                }
            }

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

        if (id == 0) {
            request.setAttribute("error", "error");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (id > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("correoUsuario", usuario.getCorreo());
            session.setAttribute("nombreUsuario", usuario.getNombreUsuario());
            session.setAttribute("ultimoTut", usuario.getUltimoTema());
            session.setAttribute("ultimoTema", usuario.getUltimoTutorial());
            request.getRequestDispatcher("CargaIndex").forward(request, response);
        }
    }
}