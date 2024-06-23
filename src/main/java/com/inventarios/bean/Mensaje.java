package com.inventarios.bean;

public class Mensaje {
    private String cod;
    private String mensaje;
    private String examenes;

    public Mensaje(String cod, String mensaje, String examenes) {
        this.cod = cod;
        this.mensaje = mensaje;
        this.examenes = examenes;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getExamenes() {
        return examenes;
    }

    public void setExamenes(String examenes) {
        this.examenes = examenes;
    }
}
