package com.inventarios.bean;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;
import java.util.List;

@XmlRootElement
public class EstudianteSession implements java.io.Serializable {
    @SuppressWarnings("compatibility:2046940122034075140")
    private static final long serialVersionUID = 1L;
    private int id;
    private String email;
    private String userName;
    private String password;
    private String fotoPerfil;
    private String nombrePerfil;
    private String nombres;
    private String apellidos;
    private String fecNacimiento;
    private String genero;
    private String nivel;
    private String examenRanking;
    private String nombreExamenRanking;
    private List<EstudianteSession> listaConectados;
    private List<Examenes> listaExamenes;
    private List<ExamenJersey> listSessionGratis;
    private String sesionConectado;
    private String notaRanking;
    private Timestamp fechahoraConexion;
    private String timeAge;
    private List<ListaNotas> notas;
    private List<String> categorias;
    private int rol;
    private String urlmenuexams;

    public EstudianteSession() {
    }

    public EstudianteSession(int id, String email, String userName, String password, String fotoPerfil, String nombrePerfil) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.nombrePerfil = nombrePerfil;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getFotoPerfil() {
        return this.fotoPerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getNombrePerfil() {
        return this.nombrePerfil;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setFecNacimiento(String fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getFecNacimiento() {
        return this.fecNacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setListaConectados(List<EstudianteSession> listaConectados) {
        this.listaConectados = listaConectados;
    }

    public List<EstudianteSession> getListaConectados() {
        return this.listaConectados;
    }

    public void setListaExamenes(List<Examenes> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }

    public List<Examenes> getListaExamenes() {
        return this.listaExamenes;
    }

    public void setListSessionGratis(List<ExamenJersey> listSessionGratis) {
        this.listSessionGratis = listSessionGratis;
    }

    public List<ExamenJersey> getListSessionGratis() {
        return this.listSessionGratis;
    }

    public void setExamenRanking(String examenRanking) {
        this.examenRanking = examenRanking;
    }

    public String getExamenRanking() {
        return this.examenRanking;
    }

    public void setNombreExamenRanking(String nombreExamenRanking) {
        this.nombreExamenRanking = nombreExamenRanking;
    }

    public String getNombreExamenRanking() {
        return this.nombreExamenRanking;
    }

    public void setNotaRanking(String notaRanking) {
        this.notaRanking = notaRanking;
    }

    public String getNotaRanking() {
        return this.notaRanking;
    }

    public void setFechahoraConexion(Timestamp fechahoraConexion) {
        this.fechahoraConexion = fechahoraConexion;
    }

    public Timestamp getFechahoraConexion() {
        return this.fechahoraConexion;
    }

    public void setSesionConectado(String sesionConectado) {
        this.sesionConectado = sesionConectado;
    }

    public String getSesionConectado() {
        return this.sesionConectado;
    }

    public void setNotas(List<ListaNotas> notas) {
        this.notas = notas;
    }

    public List<ListaNotas> getNotas() {
        return this.notas;
    }

    public void setTimeAge(String timeAge) {
        this.timeAge = timeAge;
    }

    public String getTimeAge() {
        return this.timeAge;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getRol() {
        return rol;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setUrlmenuexams(String urlmenuexams) {
        this.urlmenuexams = urlmenuexams;
    }

    public String getUrlmenuexams() {
        return urlmenuexams;
    }


    @Override
    public String toString() {
        return "{\"id\": \""+this.id
                +"\",\"email\": \""+this.email
                +"\",\"userName\": \""+this.userName
                +"\",\"password\": \""+this.password
                +"\",\"fotoPerfil\": \""+this.fotoPerfil
                +"\",\"nombrePerfil\": \""+this.nombrePerfil
                +"\",\"nombres\": \""+this.nombres
                +"\",\"apellidos\": \""+this.apellidos
                +"\",\"fecNacimiento\": \""+this.fecNacimiento
                +"\",\"genero\": \""+this.genero
                +"\",\"nivel\": \""+this.nivel
                +"\",\"examenRanking\": \""+this.examenRanking
                +"\",\"nombreExamenRanking\": \""+this.nombreExamenRanking
                +"\",\"listaConectados\": \""+this.listaConectados
                +"\",\"listaExamenes\": \""+this.listaExamenes
                +"\",\"listSessionGratis\": \""+this.listSessionGratis
                +"\",\"sesionConectado\": \""+this.sesionConectado
                +"\",\"notaRanking\": \""+this.notaRanking
                +"\",\"fechahoraConexion\": \""+this.fechahoraConexion
                +"\",\"timeAge\": \""+this.timeAge
                +"\",\"notas\": \""+this.notas
                +"\",\"categorias\": \""+this.categorias
                +"\",\"rol\": \""+this.urlmenuexams+"\"}";
    }

}