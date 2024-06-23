package com.inventarios.handler.examen;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.inventarios.handler.examen.service.ExamenSolucionAbstractHandler;
import java.util.Map;

public class ExamenSolucionHandler extends ExamenSolucionAbstractHandler {
    @Override
    protected void actualizaRespuestas(APIGatewayProxyRequestEvent request) {

    }
/*
    private HttpSession sesion;
    private ServletContext contexto;
    private EstudianteSession esb;
    private Examen e;

    / *public void init(ServletContext contexto) {
        System.out.println("=========================================================");
        this.contexto = contexto;
        this.ctrlBean = new ControlBeanNombr(sesion, contexto);
        return;
    }* /


    private void evaluarExamen(HttpServletRequest req) {
        String idExamen = req.getParameter("id_examen");
        String idExamenNombre = req.getParameter("id_examen_nombre");
        Object obj=req.getSession().getAttribute("sesione");
        esb=(EstudianteSession)obj;
        esb.setNombreExamenRanking(idExamenNombre);//NombreLargo
        esb.setExamenRanking(idExamen);//NombreCorto
        this.e = new Examen(esb, idExamen, idExamenNombre);
        sesion.setAttribute("sesione", esb);
        ExamenSesion ts = this.ctrlBean.getExamenSesion(this.e);
        if (!ts.estaEvaluado()) {
            ts.evaluar();
            esb.setNotaRanking(String.valueOf(ts.getPuntuacion()));
            ///ExamenesNombramientoData.insertarSimulacro(esb);
        }
    }

    private void listarExamenes(HttpServletRequest req) {
        String idExamen = req.getParameter("id_examen");
        String idExamenNombre = req.getParameter("id_examen_nombre");
        Object obj=req.getSession().getAttribute("sesione");
        esb=(EstudianteSession)obj;
        esb.setNombreExamenRanking(idExamenNombre);//NombreLargo
        esb.setExamenRanking(idExamen);//NombreCorto
        this.e = new Examen(esb, idExamen, idExamenNombre);
        ExamenSesion ts = this.ctrlBean.getExamenSesion(this.e);
        if (!ts.estaEvaluado()) {
            ts.evaluar();
            this.esb.setNotaRanking(String.valueOf(ts.getPuntuacion()));
        }
    }

    private void reposicionaBeans(HttpServletRequest req, String cmd){// throws UnsupportedEncodingException {
        ///req.setCharacterEncoding("UTF-8");
        / *El problema está en lis parámetros get html:
         * &id_examen_nombre=Razonamiento+L%F3gico
         * Debe ser un objeto el que se envia* /
        int id_pregunta;
        String idExamen = null;
        String idExamenNombre = null;
        if (cmd == "fb_get") {
            idExamen = req.getParameter("a_id_examen");
            idExamenNombre = req.getParameter("a_id_examen_nombre");
            String txtPregunta = req.getParameter("a_id_pregunta");
            id_pregunta = txtPregunta == null ? 1 : Integer.parseInt(txtPregunta);
        } else if (cmd == "cmd_ir_a_play") {
            idExamen = req.getParameter("a_id_examen");
            idExamenNombre = req.getParameter("a_id_examen_nombre");
            String txtPregunta = req.getParameter("a_id_pregunta");
            id_pregunta = txtPregunta == null ? 1 : Integer.parseInt(txtPregunta);
        } else {
            idExamen = req.getParameter("id_examen");
            idExamenNombre = req.getParameter("id_examen_nombre");
            id_pregunta = Integer.parseInt(req.getParameter("id_pregunta"));
            if (cmd == "fb_antr") {
                -- id_pregunta;
            } else if (c md == "fb_sigt") {
                ++id_pregunta;
            } else if (cmd == "cmd_sigt_play") {
                ++id_pregunta;
            }
        }
        / *this.esb.setUserName(user);
        this.esb.setEmail(user);
        this.esb.setPassword(pass);
        this.esb.setExamenRanking(idExamen);
        this.esb.setNombreExamenRanking(idExamenNombre);
        this.esb.setFotoPerfil(img != null ? img : req.getContextPath()+"/img/user.jpg");
        this.esb.setNombrePerfil(nombrePerfil);
        this.esb.setSesionConectado((String)sesion.getId());
        this.sesion.setAttribute("sesione", (Object)this.esb);* /
        Object obj=req.getSession().getAttribute("sesione");
        System.out.println("=============================================ingresa a ControlExamenNombr");
        System.out.println(obj.toString());//System.out.println("esb: "+esb.getApellidos());
        //System.out.println("esb: "+esb.getEmail());
        esb=(EstudianteSession)obj;
        esb.setNombreExamenRanking(idExamenNombre);//NombreLargo
        esb.setExamenRanking(idExamen);//NombreCorto
        System.out.println(esb.toString());
        this.e = new Examen(esb, idExamen, idExamenNombre);
        req.setAttribute("examen", (Object)this.ctrlBean.getExamen(this.e));
        req.setAttribute("pregunta", (Object)this.ctrlBean.getPregunta(this.e, id_pregunta));
        req.setAttribute("pregses", (Object)this.ctrlBean.getPreguntaSesion(this.e, id_pregunta));
        req.setAttribute("exses", (Object)this.ctrlBean.getExamenSesion(this.e));
        //req.setAttribute("id_pregunta", (Object)new Integer(id_pregunta));
        req.setAttribute("id_pregunta", (Object)(id_pregunta));
        sesion.setAttribute("sesione", esb);
    }

    public String getPaginaActual(HttpServletRequest req) {
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
        String pagina = null;
        switch (this.pantalla) {
            case 0: {
                pagina = "xixnxdex.html";
                break;
            }
            case 1: {
                pagina = "learn.jsp";
                break;
            }
            case 2: {
                pagina = "evalua.jsp";
                break;
            }
            case 3: {
                pagina = "reporte.jsp";
                break;
            }
            case 4: {
                pagina = "imprimir.jsp";
                break;
            }
            case 5: {
                pagina = "learnplay.jsp";
            }
            case 6: {
                pagina = "sinnotas.jsp";
            }
        }
        return pagina;
    }

    @Override
    protected void actualizaRespuestas(APIGatewayProxyRequestEvent request) {
        Map<String, String> queryParams = request.getQueryStringParameters();
        String idExamen  = queryParams.containsKey("id_examen") ? (queryParams.get("id_examen")) : "";
        String idExamenNombre = queryParams.containsKey("id_examen_nombre") ? (queryParams.get("id_examen_nombre")) : "";
        if (idExamen == null) {
            return;
        }
        if (idExamenNombre == null) {
            return;
        }
        System.out.println("**************************************************************");
        authorizationInfo
        Object obj=request.geetSession().getAttribute("sesione");
        System.out.println(obj.toString());
        //sesion.setAttribute("sesione", (Object)esb);
        //this.sesion.setAttribute("sesione", (Object)this.esb);
        //this.e = new Examen(this.esb, idExamen, idExamenNombre);
        esb=(EstudianteSession)obj;
        esb.setNombreExamenRanking(idExamenNombre);//NombreLargo
        esb.setExamenRanking(idExamen);//NombreCorto
        this.e = new Examen(esb, idExamen, idExamenNombre);
        this.e.setIdExamen(idExamen);
        this.e.setIdExamenNombreLargo(idExamenNombre);
        ExamenSesion exses = this.ctrlBean.getExamenSesion(this.e);
        if (exses.estaEvaluado()) {
            return;
        }
        int pid = Integer.parseInt(req.getParameter("id_pregunta"));
        PreguntaSesion psb = this.ctrlBean.getPreguntaSesion(this.e, pid);
        int numOpciones = psb.getNumOpciones();
        boolean[] solucion = new boolean[numOpciones];
        String[] opIds = req.getParameterValues("" + pid);
        if (opIds != null) {
            for (int j = 0; j < opIds.length; ++j) {
                solucion[Integer.parseInt((String)opIds[j]) - 1] = true;
            }
        }
        psb.setRespuestas(solucion);
    }*/
}