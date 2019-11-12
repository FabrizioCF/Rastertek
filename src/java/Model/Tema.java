/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Fabrizio Cruz
 */
public class Tema {
    
    private int idTema;
    private int idTutorial;
    private String nombre;
    
    public Tema () {
        
    }
    
    public Tema (int idTema, int idTutorial, String nombre) {
        this.idTema = idTema;
        this.idTutorial = idTutorial;
        this.nombre = nombre;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getIdTutorial() {
        return idTutorial;
    }

    public void setIdTutorial(int idTutorial) {
        this.idTutorial = idTutorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
