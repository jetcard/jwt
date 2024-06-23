package com.inventarios.bean;

public class Examen {
    private EstudianteSession estudiante;
    private String idExamen;
    private String idExamenNombreLargo;
    private Pregunta[] preguntas;
    private int id_pregunta;

    public Examen() {
        throw new RuntimeException("ExamenBean: No se puede crear desde una pagina JSP");
    }

    public Examen(EstudianteSession estudiante, String idExamen, String examenNombreLargo) {
        this.estudiante = estudiante;
        this.idExamen = idExamen.trim();
        this.idExamenNombreLargo = examenNombreLargo;
    }

    public Examen(EstudianteSession estudiante, String idExamen, String examenNombreLargo, Pregunta[] preguntas) {
        this.estudiante = estudiante;
        this.idExamen = idExamen.trim();
        this.idExamenNombreLargo = examenNombreLargo;
        this.preguntas = preguntas;
    }

    public EstudianteSession getUsuario() {
        return this.estudiante;
    }

    public void setUsuario(EstudianteSession usuario) {
        this.estudiante = usuario;
    }

    public String getIdExamen() {
        return this.idExamen;
    }

    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public int getNumPreguntas() {
        return this.preguntas.length;
    }

    public Pregunta getPregunta(int idPregunta) {
        return this.preguntas[idPregunta - 1];
    }

    public int getId_pregunta() {
        return this.id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public void setIdExamenNombreLargo(String idExamenNombreLargo) {
        this.idExamenNombreLargo = idExamenNombreLargo;
    }

    public String getIdExamenNombreLargo() {
        return this.idExamenNombreLargo;
    }
}