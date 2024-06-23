package com.inventarios.bean;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;
import java.util.List;

@XmlRootElement
public class ExamenJersey {
    private String foto;
    private String nombre;
    private String examen;
    private String codigo;
    private String nota;
    private Timestamp fechahora;
    private List<ListaNotas> notas;

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

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public String getExamen() {
        return this.examen;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return this.nota;
    }

    public void setFechahora(Timestamp fechahora) {
        this.fechahora = fechahora;
    }

    public Timestamp getFechahora() {
        return this.fechahora;
    }

    public void setNotas(List<ListaNotas> notas) {
        this.notas = notas;
    }

    public List<ListaNotas> getNotas() {
        return this.notas;
    }
}