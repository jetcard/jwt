package com.inventarios.handler.examen;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.*;

public class ControlBeanNombr {/*
    private HttpSession sesion;
    private ServletContext contexto;
    private EstudianteSession esb;
    ///public static StringBuilder visualizaError=new StringBuilder();
    public ControlBeanNombr(ServletContext contexto) {
        this.contexto = contexto;
    }

    public Pregunta getPregunta(String pid, String categoria) {
        String atributo = "pregunta_" + pid;
        Pregunta pregunta = (Pregunta)this.contexto.getAttribute(atributo);
        if (pregunta != null) {
            return pregunta;
        }
        pregunta = this.getPreguntaDelFicheroXml(pid, categoria);
        System.out.println("pregunta = "+pregunta);
        this.contexto.setAttribute(atributo, (Object)pregunta);
        return pregunta;
    }

    public Pregunta getPregunta(Examen e, int pid) {
        Examen examen = this.getExamen(e);
        return examen.getPregunta(pid);
    }

    public static List<String> splitBySingleChar(final char[] s, final char splitChar) {
        final List<String> result = new ArrayList<>();
        final int length = s.length;
        int offset = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s[i] == splitChar) {
                if (count > 0) {
                    result.add(new String(s, offset, count));
                }
                offset = i + 1;
                count = 0;
            } else {
                count++;
            }
        }
        if (count > 0) {
            result.add(new String(s, offset, count));
        }
        return result;
    }

    static void preguntaDelFicheroXmlAS(String pid, String categoria) {
        String filex = "" + File.separatorChar +"preguntas" + File.separatorChar + "nom"+ File.separatorChar +"0inicial"+ File.separatorChar +"100-200_2019"+ File.separatorChar +pid + ".xml";
        StringBuilder fichero = new StringBuilder(filex);
        ///StringBuilder fichero = new StringBuilder("preguntas");
        List<String> result = splitBySingleChar(categoria.toCharArray(), '/');
        for(String str:result){
            fichero.append(File.separatorChar+str);
        }
        ///String path = this.contexto.getRealPath("/")+File.separatorChar + fichero.toString()+File.separatorChar+ pid + ".xml";
        String png1 = "./.."+File.separatorChar + fichero.toString()+File.separatorChar+ pid;
        File file = new File(filex);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Pregunta.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Pregunta Pregunta = (Pregunta) unmarshaller.unmarshal(file);
            //si existe la imagen G0, entonces setea -p0
            Pregunta.setG0(png1+"-p0.png");
            //pero si encuentra 251-p.png, convierte a G, seteando a -p
            Pregunta.setG(png1+"-p.png");
            //si existe la imagen G en G0
            if(Pregunta.getG0()!=null&&!Pregunta.getG0().isEmpty()){
                if(Pregunta.getG0().contains("-p0")){
                    Pregunta.setG0(png1+"-p0.png");
                }else if(Pregunta.getG0().contains("-p0")){

                }
            }
            //necesita 251-p0.png
            //encuentra 251-p.png

            if(Pregunta.getG()!=null&&!Pregunta.getG().isEmpty()){
                Pregunta.setG(png1+"-p.png");
            }
            if(Pregunta.getG2()!=null&&!Pregunta.getG2().isEmpty()){
                Pregunta.setG2(png1+"-p2.png");
            }
            if(Pregunta.getG3()!=null&&!Pregunta.getG3().isEmpty()){
                Pregunta.setG3(png1+"-p3.png");
            }
            if(Pregunta.getG4()!=null&&!Pregunta.getG4().isEmpty()){
                Pregunta.setG4(png1+"-p4.png");
            }
            if(Pregunta.getG5()!=null&&!Pregunta.getG5().isEmpty()){
                Pregunta.setG5(png1+"-p5.png");
            }
            int tipo = Pregunta.getOpciones().getR().equalsIgnoreCase("r") ? Casillero.RADIO.getCasillero() : Casillero.CHECKBOX.getCasillero();
            Vector<String> temp = new Vector<String>();
            for(int i=1; i <= Pregunta.getOpciones().getNumOpciones(); i++){
                temp.add(Pregunta.getOpciones().getOpcion(i));
            }
            String[] alts = temp.toArray(new String[temp.size()]);
            boolean[] correcta = new boolean[alts.length];
            String txtRespuesta = Pregunta.getOpciones().getCorrecta();
            StringTokenizer st = new StringTokenizer(txtRespuesta, ",");
            while (st.hasMoreTokens()) {//en el caso que sea check
                correcta[Integer.parseInt((String)st.nextToken())] = true;
            }
        }catch(JAXBException jbe){
            ///System.out.println("======================");
            jbe.printStackTrace();
            ///System.out.println("======================");
        }catch (Exception e) {
            ///System.out.println("= = = = = = = = = = = =");
            //e.printStackTrace();
            ///System.out.println("= = = = = = = = = = = =");
        }
    }


    // <g0>151-p.png</g0>
    public Pregunta getPreguntaDelFicheroXml(String pid, String categoria) {
        StringBuilder fichero = new StringBuilder("preguntas");
        List<String> result = splitBySingleChar(categoria.toCharArray(), '/');
        for(String str:result){
            fichero.append(File.separatorChar+str);
        }
        String path = this.contexto.getRealPath("/")+File.separatorChar + fichero.toString()+File.separatorChar+ pid + ".xml";
        String png1 = "./.."+File.separatorChar + fichero.toString()+File.separatorChar+ pid;
        File file = new File(path);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Pregunta.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Pregunta Pregunta = (Pregunta) unmarshaller.unmarshal(file);
            //si existe la imagen G0, entonces setea -p0
            //¿qué es lo que se encuentra?
            if(Pregunta.getG0()!=null&&!Pregunta.getG0().isEmpty()){
                if(Pregunta.getG0().trim().equals(pid+"-p0.png")){
                    Pregunta.setG0(png1+"-p0.png");
                }else if(Pregunta.getG0().trim().equals(pid+"-p.png")){
                    Pregunta.setG0(png1+"-p.png");
                }else if(Pregunta.getG0().trim().equals(pid+"-p1.png")){
                    Pregunta.setG0(png1+"-p1.png");
                }else if(Pregunta.getG0().trim().equals(pid+"-p2.png")){
                    Pregunta.setG0(png1+"-p2.png");
                }else if(Pregunta.getG0().trim().equals(pid+"-p3.png")){
                    Pregunta.setG0(png1+"-p3.png");
                }else if(Pregunta.getG0().trim().equals(pid+"-p4.png")){
                    Pregunta.setG0(png1+"-p4.png");
                }else if(Pregunta.getG0().trim().equals(pid+"-p5.png")){
                    Pregunta.setG0(png1+"-p5.png");
                }else{
                    Pregunta.setG0(Pregunta.getG0());
                }
            }
            if(Pregunta.getG()!=null&&!Pregunta.getG().isEmpty()){
                if(Pregunta.getG().trim().equals(pid+"-p0.png")){
                    Pregunta.setG(png1+"-p0.png");
                }else if(Pregunta.getG().trim().equals(pid+"-p.png")){
                    Pregunta.setG(png1+"-p.png");
                }else if(Pregunta.getG().trim().equals(pid+"-p1.png")){
                    Pregunta.setG(png1+"-p1.png");
                }else if(Pregunta.getG().trim().equals(pid+"-p2.png")){
                    Pregunta.setG(png1+"-p2.png");
                }else if(Pregunta.getG().trim().equals(pid+"-p3.png")){
                    Pregunta.setG(png1+"-p3.png");
                }else if(Pregunta.getG().trim().equals(pid+"-p4.png")){
                    Pregunta.setG(png1+"-p4.png");
                }else if(Pregunta.getG().trim().equals(pid+"-p5.png")){
                    Pregunta.setG(png1+"-p5.png");
                }else{
                    Pregunta.setG(Pregunta.getG0());
                }
            }
            if(Pregunta.getG2()!=null&&!Pregunta.getG2().isEmpty()){
                if(Pregunta.getG2().trim().equals(pid+"-p0.png")){
                    Pregunta.setG2(png1+"-p0.png");
                }else if(Pregunta.getG2().trim().equals(pid+"-p.png")){
                    Pregunta.setG2(png1+"-p.png");
                }else if(Pregunta.getG2().trim().equals(pid+"-p1.png")){
                    Pregunta.setG2(png1+"-p1.png");
                }else if(Pregunta.getG2().trim().equals(pid+"-p2.png")){
                    Pregunta.setG2(png1+"-p2.png");
                }else if(Pregunta.getG2().trim().equals(pid+"-p3.png")){
                    Pregunta.setG2(png1+"-p3.png");
                }else if(Pregunta.getG2().trim().equals(pid+"-p4.png")){
                    Pregunta.setG2(png1+"-p4.png");
                }else if(Pregunta.getG2().trim().equals(pid+"-p5.png")){
                    Pregunta.setG2(png1+"-p5.png");
                }else{
                    Pregunta.setG2(Pregunta.getG0());
                }
            }
            if(Pregunta.getG3()!=null&&!Pregunta.getG3().isEmpty()){
                if(Pregunta.getG3().trim().equals(pid+"-p0.png")){
                    Pregunta.setG3(png1+"-p0.png");
                }else if(Pregunta.getG3().trim().equals(pid+"-p.png")){
                    Pregunta.setG3(png1+"-p.png");
                }else if(Pregunta.getG3().trim().equals(pid+"-p1.png")){
                    Pregunta.setG3(png1+"-p1.png");
                }else if(Pregunta.getG3().trim().equals(pid+"-p2.png")){
                    Pregunta.setG3(png1+"-p2.png");
                }else if(Pregunta.getG3().trim().equals(pid+"-p3.png")){
                    Pregunta.setG3(png1+"-p3.png");
                }else if(Pregunta.getG3().trim().equals(pid+"-p4.png")){
                    Pregunta.setG3(png1+"-p4.png");
                }else if(Pregunta.getG3().trim().equals(pid+"-p5.png")){
                    Pregunta.setG3(png1+"-p5.png");
                }else{
                    Pregunta.setG3(Pregunta.getG0());
                }
            }
            if(Pregunta.getG4()!=null&&!Pregunta.getG4().isEmpty()){
                if(Pregunta.getG4().trim().equals(pid+"-p0.png")){
                    Pregunta.setG4(png1+"-p0.png");
                }else if(Pregunta.getG4().trim().equals(pid+"-p.png")){
                    Pregunta.setG4(png1+"-p.png");
                }else if(Pregunta.getG4().trim().equals(pid+"-p1.png")){
                    Pregunta.setG4(png1+"-p1.png");
                }else if(Pregunta.getG4().trim().equals(pid+"-p2.png")){
                    Pregunta.setG4(png1+"-p2.png");
                }else if(Pregunta.getG4().trim().equals(pid+"-p3.png")){
                    Pregunta.setG4(png1+"-p3.png");
                }else if(Pregunta.getG4().trim().equals(pid+"-p4.png")){
                    Pregunta.setG4(png1+"-p4.png");
                }else if(Pregunta.getG4().trim().equals(pid+"-p5.png")){
                    Pregunta.setG4(png1+"-p5.png");
                }else{
                    Pregunta.setG4(Pregunta.getG0());
                }
            }
            if(Pregunta.getG5()!=null&&!Pregunta.getG5().isEmpty()){
                if(Pregunta.getG5().trim().equals(pid+"-p0.png")){
                    Pregunta.setG5(png1+"-p0.png");
                }else if(Pregunta.getG5().trim().equals(pid+"-p.png")){
                    Pregunta.setG5(png1+"-p.png");
                }else if(Pregunta.getG5().trim().equals(pid+"-p1.png")){
                    Pregunta.setG5(png1+"-p1.png");
                }else if(Pregunta.getG5().trim().equals(pid+"-p2.png")){
                    Pregunta.setG5(png1+"-p2.png");
                }else if(Pregunta.getG5().trim().equals(pid+"-p3.png")){
                    Pregunta.setG5(png1+"-p3.png");
                }else if(Pregunta.getG5().trim().equals(pid+"-p4.png")){
                    Pregunta.setG5(png1+"-p4.png");
                }else if(Pregunta.getG5().trim().equals(pid+"-p5.png")){
                    Pregunta.setG5(png1+"-p5.png");
                }else{
                    Pregunta.setG5(Pregunta.getG0());
                }
            }
            int tipo = Pregunta.getOpciones().getR().equalsIgnoreCase("r") ? Casillero.RADIO.getCasillero() : Casillero.CHECKBOX.getCasillero();
            Vector<String> temp = new Vector<String>();
            for(int i=1; i <= Pregunta.getOpciones().getNumOpciones(); i++){
                temp.add(Pregunta.getOpciones().getOpcion(i));
            }
            String[] alts = temp.toArray(new String[temp.size()]);
            boolean[] correcta = new boolean[alts.length];
            String txtRespuesta = Pregunta.getOpciones().getCorrecta();
            StringTokenizer st = new StringTokenizer(txtRespuesta, ",");
            while (st.hasMoreTokens()) {//en el caso que sea check
                correcta[Integer.parseInt((String)st.nextToken())] = true;
            }
            return Pregunta;
        }catch(JAXBException jbe){
            System.out.println("======================");
            jbe.printStackTrace();
            System.out.println("======================");
            return null;
        }catch (Exception e) {
            System.out.println("= = = = = = = = = = = =");
            / *visualizaError.append(e.toString()+" "+e.getMessage());
            visualizaError.append("\n");
            visualizaError.append(e.getStackTrace().toString());* /
            e.printStackTrace();
            System.out.println("= = = = = = = = = = = =");
            return null;
        }
    }

    public Examen getExamen(Examen e) {
        String atributo = "examen_" + e.getUsuario().getEmail() + "_" + e.getIdExamen() + "_" + e.getIdExamenNombreLargo().trim();
        Examen examen = (Examen)this.contexto.getAttribute(atributo);
        if (examen != null) {
            return examen;
        }
        examen = this.getExamenDelDocXml(e);
        this.contexto.setAttribute(atributo, (Object)examen);
        return examen;
    }

    public Examen getExamenDelDocXml(Examen e) {
        try {
            return this.getExamenDesdeLista(e.getUsuario(), e.getIdExamen(), e.getIdExamenNombreLargo());
        }
        catch (Exception exc) {
            return null;
        }
    }

    public Examen getExamenDesdeLista(EstudianteSession usuario, String idExamen, String idExamenLargo) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException, InstantiationException{
        List<Pregunta> temp=new ArrayList<>();
        String categoria=null;
        String[] strarray=null;
        Map<String, String[]> mapArr = Diccionario.camposMap(idExamen);
        for(Map.Entry mapa:mapArr.entrySet()){
            categoria=mapa.getKey().toString();
            strarray=(String[])mapa.getValue();
        }
        for(int k=0;k<strarray.length;k++){
            System.out.println(" k = "+k+" strarray[k]="+strarray[k]);
            ///visualizaError.append(strarray[k]+'\n');
            temp.add(getPregunta(String.valueOf(strarray[k]), categoria));
        }
        // Crea el array de preguntas que componen el examen
        Pregunta[] preguntas = (Pregunta[])temp.toArray( new Pregunta[temp.size()] );
        ///Pregunta.As[] preguntas = (Pregunta.As[])temp.toArray( new Pregunta.As[temp.size()] );
        // Devuelve la nueva instancia del examen
        System.out.println(" Pregunta[] preguntas = "+preguntas);
        return( new Examen(usuario, idExamen, idExamenLargo, preguntas) );
    }

    public PreguntaSesion getPreguntaSesion(Examen e, int pid) {
        String atributo = "pregSesion_" + pid + "_" + e.getUsuario().getEmail() + "_" + e.getIdExamen();
        System.out.println(" atributo = "+atributo);
        PreguntaSesion psb = (PreguntaSesion)this.sesion.getAttribute(atributo);
        System.out.println(" psb = "+psb);
        if (psb != null) {
            return psb;
        }
        psb = new PreguntaSesion(this.getPregunta(e, pid));
        System.out.println("  psb = "+psb);
        this.sesion.setAttribute(atributo, (Object)psb);
        return psb;
    }

    public ExamenSesion getExamenSesion(Examen e) {
        String atributo = "examenSesion_" + e.getUsuario().getEmail() + "_" + e.getIdExamen() + "_" + e.getIdExamenNombreLargo().trim();
        System.out.println("----- atributo = "+atributo);
        ExamenSesion exsb = (ExamenSesion)this.sesion.getAttribute(atributo);
        //System.out.println("----- exsb = "+exsb);
        this.esb = (EstudianteSession)this.sesion.getAttribute("sesione");
        System.out.println("----- this.esb = "+this.esb);
        if (exsb != null) {
            return exsb;
        }
        int numPreguntas = this.getExamen(e).getNumPreguntas();
        System.out.println("----- int numPreguntas = "+numPreguntas);
        PreguntaSesion[] psb = new PreguntaSesion[numPreguntas];
        for (int i = 0; i < numPreguntas; ++i) {
            psb[i] = this.getPreguntaSesion(e, i + 1);
            System.out.println("----- psb[i] = "+psb[i]);
        }
        exsb = new ExamenSesion(e.getIdExamen(), e.getIdExamenNombreLargo(), psb);
        System.out.println("----- exsb = "+exsb);
        this.sesion.setAttribute(atributo, (Object)exsb);
        return exsb;
    }*/
}