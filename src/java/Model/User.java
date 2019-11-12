/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.DB_Utils;
import java.io.InputStream;
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
import javax.sql.DataSource;

/**
 *
 * @author Fabrizio Cruz
 */
public class User {

    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correo;
    private String contrasena;
    private byte[] imgPerfil;
    private int completoOnboard;
    private int activo;
    private int ultimoTutorial;
    private int ultimoTema;

    // Getters/Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(byte[] imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public int getCompletoOnboard() {
        return completoOnboard;
    }

    public void setCompletoOnboard(int completoOnboard) {
        this.completoOnboard = completoOnboard;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getUltimoTutorial() {
        return ultimoTutorial;
    }
    
    public void setUltimoTutorial(int ultimoTutorial) {
        this.ultimoTutorial = ultimoTutorial;
    }

    public int getUltimoTema() {
        return ultimoTema;
    }

    public void setUltimoTema(int ultimoTema) {
        this.ultimoTema = ultimoTema;
    }

    // Constructores
    public User() {

    }

    public User(int idUsuario, String nombreUsuario, String apellidoUsuario,
            String correo, String contrasena, byte[] imgPerfil,
            int onboard) {

        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.imgPerfil = imgPerfil;
        this.completoOnboard = onboard;
    }

    public User(String nombreUsuario, String correo, String contrasena,
            int tutorial, int tema) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ultimoTutorial = tutorial;
        this.ultimoTema = tema;
    }

    public User(User other) {
        this.idUsuario = other.getIdUsuario();
        this.nombreUsuario = other.getNombreUsuario();
        this.apellidoUsuario = other.getApellidoUsuario();
        this.correo = other.getCorreo();
        this.contrasena = other.getContrasena();
        this.imgPerfil = other.getImgPerfil();
        this.completoOnboard = other.getCompletoOnboard();
        this.activo = other.getActivo();
    }

    // Métodos
    //Obtener todos los usuarios segun un parametro
    //1 Activos
    //0 Inactivos
    //-1 Todos
    static public List<User> GetAllUsers(int status) throws NamingException {
        List<User> usuarios = new ArrayList<User>();
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

            stmt = conn.prepareCall(DB_Utils.SP_GETALL_USER);
            stmt.setInt(1, status);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();

            while (rs.next()) {
                //int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombreUsuario");
                String apellido = rs.getString("apellidoUsuario");
                String correo = rs.getString("correo");
                String pass = rs.getString("contrasena");
                //byte[] imgP = rs.getBytes("imgPerfil");
                int tut = rs.getInt("ultimoTutorial");
                int tem = rs.getInt("ultimoTema");

                User us = new User(nombre, correo, pass, tut, tem);
                usuarios.add(us);
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
        return usuarios;
    }

    //Agregar un usuario
    static public void AddUser(String userName, InputStream userImage) {
        InitialContext iC = null;
        Context context = null;
        Connection con = null;
        ResultSet rS = null;
        CallableStatement statement = null;
        try {
            iC = new InitialContext();
            context = (Context) iC.lookup("java:comp/env");

            DataSource dS = (DataSource) context.lookup("jdbc/myDB");
            con = dS.getConnection();

            statement = con.prepareCall(DB_Utils.SP_ADD_USER);
            statement.setString(1, userName);
            statement.setBinaryStream(2, userImage);
            rS = statement.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger("ERROR al intentar obtener el DataSource: " + ex.getMessage());
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
                Logger.getLogger("ERROR (" + ex.getErrorCode() + "): " + ex.getMessage());
            }
        }
    }
}
