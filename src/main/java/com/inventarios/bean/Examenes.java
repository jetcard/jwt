package com.inventarios.bean;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Examenes implements Serializable { //implements Comparable<Examenes>{
    private String examen;//nombreLargo
    private String rolename;//nombreCorto
    private String codMinedu;
    private String imagen;
    private String tipo;
    private String nroPreguntas;
    private String ventaja;//ventaja;//PREMIUM, GRATIS, SIMULACRO, TEMARIO
    private String pdf;
    private String linea;
    private Double precio;
    private String precioEnLetras;
    private String annio;

    public Examenes(){
    }

    /*public Examenes(String rolename) {
        this.rolename = rolename;
    }
    public Examenes(String linea) {
        this.linea = linea;
    }*/
/*
    public Examenes(String examen, String rolename, String codMinedu, String imagen, String tipo,
                    String nroPreguntas, String ventaja, String pdf, String linea,
                    Double precio, String precioEnLetras, String annio) {
        this.examen = examen;
        this.rolename = rolename;
        this.codMinedu = codMinedu;
        this.imagen = imagen;
        this.tipo = tipo;
        this.nroPreguntas = nroPreguntas;
        this.ventaja = ventaja;
        this.pdf = pdf;
        this.linea = linea;
        this.precio = precio;
        this.precioEnLetras = precioEnLetras;
        this.annio = annio;
    }*/

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getCodMinedu() {
        return codMinedu;
    }

    public void setCodMinedu(String codMinedu) {
        this.codMinedu = codMinedu;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNroPreguntas() {
        return nroPreguntas;
    }

    public void setNroPreguntas(String nroPreguntas) {
        this.nroPreguntas = nroPreguntas;
    }

    public String getVentaja() {
        return ventaja;
    }

    public void setVentaja(String ventaja) {
        this.ventaja = ventaja;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getPrecioEnLetras() {
        return precioEnLetras;
    }

    public void setPrecioEnLetras(String precioEnLetras) {
        this.precioEnLetras = precioEnLetras;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    /*
    @Override
    public int compareTo(Examenes o) {
        return this.getExamen().compareTo(o.getExamen());
    }*/

}