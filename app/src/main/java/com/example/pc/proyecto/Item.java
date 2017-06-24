package com.example.pc.proyecto;

/**
 * Created by PC on 28/05/2017.
 */

public class Item {
    private int imagen;
    private  String titulo;
    private String contenido;

    public Item(int imagen, String titulo, String contenido) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
