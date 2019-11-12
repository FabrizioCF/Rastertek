/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Fabrizio Cruz
 */
public class DB_Utils {

    /* estos son las llamadas a los stored procedures */
    public static String SP_ADD_USER = "CALL SP_AddUser(?,?,?,?);";
    public static String SP_GETALL_USER = "CALL SP_GetAllUsers(?);";
    public static String FN_VERIFY_USER = "SELECT AutenticaUsuario(?,?) as id;";
    public static String SP_ADD_TUTORIAL = "CALL SP_AddTutorial(?,?,?);";
    public static String SP_GET_ALL_TUTORIALS = "CALL SP_GetAllTutorials(?);";
    public static String SP_GET_LAST_TUTORIAL = "CALL SP_GetLastTutorial(?);";
    public static String SP_GetTutorialImg = "Call SP_GetTutorialImg(?);";
    public static String SP_GetTemasTutorial = "Call SP_GetTemasTutorial(?);";
    public static String SP_AddTema = "Call SP_AddTema(?,?,?);";
    public static String SP_GetTemaImg = "Call SP_GetTemaImg(?);";
    public static String SP_ActualizaTema = "Call SP_ActualizaTema(?,?);";
    public static String SP_ConsultaUsuario = "Call SP_ConsultaUsuario(?);";

    public static String GetExtension(String contentType) {
        switch (contentType) {
            case "image/png":
                return ".png";
            case "image/jpeg":
                return ".jpg";
            case "video/mp4":
                return ".mp4";
        }
        return ".ext";
    }
}
