package com.inventarios.bean;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaNotas {
    private String examen;
    private String fechahora;
    private String foto;
    private String nombre;
    private String nota;

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public String getExamen() {
        return this.examen;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getFechahora() {
        return this.fechahora;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return this.nota;
    }
}