package com.example.miapp;

import java.io.Serializable;

public class Obj implements Serializable {
    private String titulo;
    private String descripcion;
    private boolean complete;
    private String due_date;

    public Obj(String titulo, String descripcion, String due_date, boolean complete){

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.complete = complete;
        this.due_date = due_date;
    }

    public Obj() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDueDate() {
        return due_date;
    }

    public void setDueDate(String due_date) {
        this.due_date = due_date;
    }

}

