package com.inventarios.bean;

public class PreguntaSesion {
    private Pregunta pregunta;
    private boolean[] solucion;
    private boolean corregido;

    public PreguntaSesion() {
        throw new RuntimeException("PreguntaSesionBean: No se puede crear desde una p\u00e1gina JSP");
    }

    public PreguntaSesion(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.solucion = new boolean[pregunta.getOpciones().getNumOpciones()];
        this.corregido = false;
    }

    public int getNumOpciones() {
        return this.pregunta.getOpciones().getNumOpciones();
    }

    public void setRespuestas(boolean[] solucion) {
        this.solucion = solucion;
    }

    public boolean esRespuesta(int pid) {
        return this.solucion[pid - 1];
    }

    public void evaluar() {
        this.corregido = true;
        for (int i = 1; i <= this.pregunta.getOpciones().getNumOpciones(); ++i) {
            if (this.pregunta.getOpciones().esRespuesta(i) == this.esRespuesta(i)) continue;
            this.corregido = false;
            break;
        }
    }

    public boolean esCorrecta() {
        return this.corregido;
    }

}
