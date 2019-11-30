/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.EmailUtility;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabrizio Cruz
 */
public class EnvioCorreos extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("correo");
        String subject = "Bienvenido a Rastertek!";
        //String content = "Esto es un correo de prueba.";
        String content = "<div style='background-color:#3e3e3e;'>"
                + "<h1 style='color:#b2dbca; text-align:center'>Bienvenido!</h1>"
                + "<p style='color:#cccccc; text-align: center;'>Gracias por subscribirse a nuestro programa de noticias!</p>"
                + "<p style='color:#cccccc; text-align: center;'>Usted será notificado cada vez que nuevo contenido sea agregado a la página.</p>"
                + "<br/><br/><br/>"
                + "<p style='color:#b2dbca; font-weight:800; font-size:12px; text-align: center;'> Enviado automáticamente por el equipo de Rastertek SA de CV </p>"
                + "</div>";

        String resultMessage = "";

        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("emailMessage", resultMessage);
            request.getRequestDispatcher("CargaIndex").forward(request, response);
        }
    }
}
