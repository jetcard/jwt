package com.inventarios.bean;

import java.util.StringTokenizer;
import java.util.Vector;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="q0" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="g0" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="q" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="g" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="q2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="g2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="q3" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="g3" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="q4" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="g4" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="q5" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="g5" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="as"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="r" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="correcta" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="t" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="i" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="x2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="i2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="v1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="d1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="v2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="d2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="v3" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="d3" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="v4" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="d4" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="v5" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="d5" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="v6" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="d6" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="v7" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="d7" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",
        propOrder =
                { "q0", "g0", "q", "g", "q2", "g2", "q3", "g3", "q4", "g4", "q5", "g5", "as", "x", "t", "i", "x2", "i2",
                        "x3", "x4", "x5", "x6", "x7",
                        "v1", "d1", "v2", "d2", "v3", "d3", "v4", "d4", "v5", "d5", "v6", "d6", "v7", "d7"
                })
@XmlRootElement(name = "p")
public class Pregunta {
    @XmlElement(required = true)
    protected String q0;
    @XmlElement(required = true)
    protected String g0;
    @XmlElement(required = true)
    protected String q;
    @XmlElement(required = true)
    protected String g;
    @XmlElement(required = true)
    protected String q2;
    @XmlElement(required = true)
    protected String g2;
    @XmlElement(required = true)
    protected String q3;
    @XmlElement(required = true)
    protected String g3;
    @XmlElement(required = true)
    protected String q4;
    @XmlElement(required = true)
    protected String g4;
    @XmlElement(required = true)
    protected String q5;
    @XmlElement(required = true)
    protected String g5;
    @XmlElement(required = true)
    protected Pregunta.Opciones as;
    @XmlElement(required = true)
    protected String x;
    @XmlElement(required = true)
    protected String t;
    @XmlElement(required = true)
    protected String i;
    @XmlElement(required = true)
    protected String x2;
    @XmlElement(required = true)
    protected String i2;
    @XmlElement(required = true)
    protected String x3;
    @XmlElement(required = true)
    protected String x4;
    @XmlElement(required = true)
    protected String x5;
    @XmlElement(required = true)
    protected String x6;
    @XmlElement(required = true)
    protected String x7;
    @XmlElement(required = true)
    protected String v1;
    @XmlElement(required = true)
    protected String d1;
    @XmlElement(required = true)
    protected String v2;
    @XmlElement(required = true)
    protected String d2;
    @XmlElement(required = true)
    protected String v3;
    @XmlElement(required = true)
    protected String d3;
    @XmlElement(required = true)
    protected String v4;
    @XmlElement(required = true)
    protected String d4;
    @XmlElement(required = true)
    protected String v5;
    @XmlElement(required = true)
    protected String d5;
    @XmlElement(required = true)
    protected String v6;
    @XmlElement(required = true)
    protected String d6;
    @XmlElement(required = true)
    protected String v7;
    @XmlElement(required = true)
    protected String d7;

    /**
     * Gets the value of the q0 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQ0() {
        return q0;
    }

    /**
     * Sets the value of the q0 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQ0(String value) {
        this.q0 = value;
    }

    /**
     * Gets the value of the g0 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getG0() {
        return g0;
    }

    /**
     * Sets the value of the g0 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setG0(String value) {
        this.g0 = value;
    }

    /**
     * Gets the value of the q property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQ() {
        return q;
    }

    /**
     * Sets the value of the q property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQ(String value) {
        this.q = value;
    }

    /**
     * Gets the value of the g property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getG() {
        return g;
    }

    /**
     * Sets the value of the g property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setG(String value) {
        this.g = value;
    }

    /**
     * Gets the value of the q2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQ2() {
        return q2;
    }

    /**
     * Sets the value of the q2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQ2(String value) {
        this.q2 = value;
    }

    /**
     * Gets the value of the g2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getG2() {
        return g2;
    }

    /**
     * Sets the value of the g2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setG2(String value) {
        this.g2 = value;
    }

    /**
     * Gets the value of the q3 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQ3() {
        return q3;
    }

    /**
     * Sets the value of the q3 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQ3(String value) {
        this.q3 = value;
    }

    /**
     * Gets the value of the g3 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getG3() {
        return g3;
    }

    /**
     * Sets the value of the g3 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setG3(String value) {
        this.g3 = value;
    }

    /**
     * Gets the value of the q4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQ4() {
        return q4;
    }

    /**
     * Sets the value of the q4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQ4(String value) {
        this.q4 = value;
    }

    /**
     * Gets the value of the g4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getG4() {
        return g4;
    }

    /**
     * Sets the value of the g4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setG4(String value) {
        this.g4 = value;
    }

    /**
     * Gets the value of the q5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQ5() {
        return q5;
    }

    /**
     * Sets the value of the q5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQ5(String value) {
        this.q5 = value;
    }

    /**
     * Gets the value of the g5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getG5() {
        return g5;
    }

    /**
     * Sets the value of the g5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setG5(String value) {
        this.g5 = value;
    }

    /**
     * Gets the value of the as property.
     *
     * @return
     *     possible object is
     *     {@link Pregunta.Opciones }
     *
     */
    public Pregunta.Opciones getOpciones() {
        return as;
    }

    /**
     * Sets the value of the as property.
     *
     * @param value
     *     allowed object is
     *     {@link Pregunta.Opciones }
     *
     */
    public void setAs(Pregunta.Opciones value) {
        this.as = value;
    }

    /**
     * Gets the value of the x property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setX(String value) {
        this.x = value;
    }

    /**
     * Gets the value of the t property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getT() {
        return t;
    }

    /**
     * Sets the value of the t property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setT(String value) {
        this.t = value;
    }

    /**
     * Gets the value of the i property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getI() {
        return i;
    }

    /**
     * Sets the value of the i property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setI(String value) {
        this.i = value;
    }

    /**
     * Gets the value of the x2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getX2() {
        return x2;
    }

    /**
     * Sets the value of the x2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setX2(String value) {
        this.x2 = value;
    }

    /**
     * Gets the value of the i2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getI2() {
        return i2;
    }

    /**
     * Sets the value of the i2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setI2(String value) {
        this.i2 = value;
    }

    public String getX3() {
        return x3;
    }

    public void setX3(String value) {
        this.x3 = value;
    }

    public String getX4() {
        return x4;
    }

    public void setX4(String value) {
        this.x4 = value;
    }

    public String getX5() {
        return x5;
    }

    public void setX5(String value) {
        this.x5 = value;
    }

    public String getX6() {
        return x6;
    }

    public void setX6(String value) {
        this.x6 = value;
    }

    public String getX7() {
        return x7;
    }

    public void setX7(String value) {
        this.x7 = value;
    }

    /**
     * Gets the value of the v1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getV1() {
        return v1;
    }

    /**
     * Sets the value of the v1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setV1(String value) {
        this.v1 = value;
    }

    /**
     * Gets the value of the d1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getD1() {
        return d1;
    }

    /**
     * Sets the value of the d1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setD1(String value) {
        this.d1 = value;
    }

    /**
     * Gets the value of the v2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getV2() {
        return v2;
    }

    /**
     * Sets the value of the v2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setV2(String value) {
        this.v2 = value;
    }

    /**
     * Gets the value of the d2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getD2() {
        return d2;
    }

    /**
     * Sets the value of the d2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setD2(String value) {
        this.d2 = value;
    }

    /**
     * Gets the value of the v3 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getV3() {
        return v3;
    }

    /**
     * Sets the value of the v3 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setV3(String value) {
        this.v3 = value;
    }

    /**
     * Gets the value of the d3 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getD3() {
        return d3;
    }

    /**
     * Sets the value of the d3 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setD3(String value) {
        this.d3 = value;
    }

    /**
     * Gets the value of the v4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getV4() {
        return v4;
    }

    /**
     * Sets the value of the v4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setV4(String value) {
        this.v4 = value;
    }

    /**
     * Gets the value of the d4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getD4() {
        return d4;
    }

    /**
     * Sets the value of the d4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setD4(String value) {
        this.d4 = value;
    }

    /**
     * Gets the value of the v5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getV5() {
        return v5;
    }

    /**
     * Sets the value of the v5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setV5(String value) {
        this.v5 = value;
    }

    /**
     * Gets the value of the d5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getD5() {
        return d5;
    }

    /**
     * Sets the value of the d5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setD5(String value) {
        this.d5 = value;
    }

    /**
     * Gets the value of the v6 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getV6() {
        return v6;
    }

    /**
     * Sets the value of the v6 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setV6(String value) {
        this.v6 = value;
    }

    /**
     * Gets the value of the d6 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getD6() {
        return d6;
    }

    /**
     * Sets the value of the d6 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setD6(String value) {
        this.d6 = value;
    }

    /**
     * Gets the value of the v7 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getV7() {
        return v7;
    }

    /**
     * Sets the value of the v7 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setV7(String value) {
        this.v7 = value;
    }

    /**
     * Gets the value of the d7 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getD7() {
        return d7;
    }

    /**
     * Sets the value of the d7 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setD7(String value) {
        this.d7 = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="r" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="correcta" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "a" })
    public static class Opciones {

        ///protected List<String> a;
        protected String[] a;
        @XmlAttribute(name = "r", required = true)
        protected String r;
        @XmlAttribute(name = "correcta", required = true)
        protected String correcta;
        ///protected boolean[] correcta;
        ///protected boolean[] solucion;
        /*public List<String> getA() {
            if (a == null) {
                a = new ArrayList<String>();
            }
            return this.a;
        }*/


        /**
         * Gets the value of the a property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the a property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getA().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         *
         *
         */
        public void setA(String[] a) {
            this.a = a;
        }

        public String[] getA() {
            return a;
        }

        /**
         * Gets the value of the r property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getR() {
            return r;
        }

        /**
         * Sets the value of the r property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setR(String value) {
            this.r = value;
        }


        /**
         * Gets the value of the correcta property.
         *
         * /
         public boolean getCorrecta() {
         return correcta;
         }

         /**
         * Sets the value of the correcta property.
         *
         * /
         public void setCorrecta(boolean value) {
         this.correcta = value;
         }*
         public void setCorrecta(boolean[] correcta) {
         this.correcta = correcta;
         }

         public boolean[] getCorrecta() {
         return correcta;
         }
         */
        public void setCorrecta(String correcta) {
            this.correcta = correcta;
        }

        public String getCorrecta() {
            return correcta;
        }
        ///////
        public int getNumOpciones() {
            return this.getA().length;
        }

        public String getOpcion(int pid) {
            return this.getA()[pid - 1];
        }

        public boolean esRespuesta(int pid) {
            Vector<String> temp = new Vector<String>();
            for(int i=1; i <= getNumOpciones(); i++){
                temp.add(getOpcion(i));
            }
            String[] alts = temp.toArray(new String[temp.size()]);
            boolean[] correcta = new boolean[alts.length];
            String txtRespuesta = getCorrecta();
            StringTokenizer st = new StringTokenizer(txtRespuesta, ",");
            while (st.hasMoreTokens()) {//en el caso que sea check
                correcta[Integer.parseInt((String)st.nextToken())] = true;
            }
            //boolean[] solucion=new boolean[pid - 1];
            return correcta[pid - 1];
        }

        public int getTipo() {
            return this.getR().equalsIgnoreCase("r") ? Casillero.RADIO.getCasillero() : Casillero.CHECKBOX.getCasillero();
        }

        public static String getIdOpcion(int pid) {
            int id = pid - 1;
            String letra = "";
            while (id >= 0) {
                letra = "" + (char)((char)(id % 26) + 65) + letra;
                id = id / 26 - 1;
            }
            return letra;
        }

    }
}
