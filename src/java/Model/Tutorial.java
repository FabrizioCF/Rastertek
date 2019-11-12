/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio Cruz
 */
public class Tutorial {

    public Tutorial() {
        this.listaTema = new ArrayList<>();

    }

    public Tutorial(int idTutorial, String nombre, String descripcion,
            byte[] imagen, int activo) {
        this.listaTema = new ArrayList<>();

        this.idTutorial = idTutorial;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgTutorial = imagen;
        this.activo = activo;
    }

    public Tutorial(String nombre, String descripcion, byte[] imagen) {
        this.listaTema = new ArrayList<>();

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgTutorial = imagen;
    }
    
    public Tutorial(int id, String nombre, String descripcion, byte[] imagen) {
        this.listaTema = new ArrayList<>();

        this.idTutorial = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgTutorial = imagen;
    }
    
    public Tutorial(int id, String nombre, String descripcion) {
        this.listaTema = new ArrayList<>();

        this.idTutorial = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Atributos
    private int idTutorial;
    private String nombre;
    private String descripcion;
    private byte[] imgTutorial;
    private int activo;
    private List<Tema> listaTema;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImgTutorial() {
        return imgTutorial;
    }

    public void setImgTutorial(byte[] imgTutorial) {
        this.imgTutorial = imgTutorial;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public List<Tema> getListaTema() {
        return listaTema;
    }

    public void setListaTema(List<Tema> listaTema) {
        this.listaTema = listaTema;
    }
}
