package com.inventarios.bean;

public class ExamenSesion {
    private String nombreExamen;
    private String nombreExamenLargo;
    private PreguntaSesion[] sesPreguntas;
    private boolean evaluado;
    private int numPregCorrectas;
    private int puntuacion;

    public ExamenSesion() {
        throw new RuntimeException("ExamenSesionBean: No se puede crear desde una JSP");
    }

    public ExamenSesion(String nombreExamen, String nombreExamenLargo, PreguntaSesion[] sesPreguntas) {
        System.out.println("ExamenSesionBean(" + nombreExamen + ", " + nombreExamenLargo + ", PreguntaSesionBean[]=" + sesPreguntas + ")");
        this.nombreExamen = nombreExamen;
        this.nombreExamenLargo = nombreExamenLargo;
        this.sesPreguntas = sesPreguntas;
        this.evaluado = false;
        this.numPregCorrectas = 0;
        this.puntuacion = 0;
    }

    public String getNombreExamen() {
        return this.nombreExamen;
    }

    public boolean estaEvaluado() {
        return this.evaluado;
    }

    public void evaluar() {
        this.evaluado = true;
        this.numPregCorrectas = 0;
        for (int i = 0; i < this.sesPreguntas.length; ++i) {
            this.sesPreguntas[i].evaluar();
            if (!this.sesPreguntas[i].esCorrecta()) continue;
            ++this.numPregCorrectas;
        }
        this.puntuacion = (int)(100.0 * (double)this.numPregCorrectas / (double)this.sesPreguntas.length);
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public int getNumPreguntas() {
        return this.sesPreguntas.length;
    }

    public int getNumPregAcertadas() {
        return this.numPregCorrectas;
    }

    public int getNumPregFalladas() {
        return this.sesPreguntas.length - this.numPregCorrectas;
    }

    public boolean esCorrecta(int idPregunta) {
        return this.sesPreguntas[idPregunta - 1].esCorrecta();
    }

    public String getNombreExamenLargo() {
        return this.nombreExamenLargo;
    }
}
