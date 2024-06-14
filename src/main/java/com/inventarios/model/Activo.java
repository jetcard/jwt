package com.inventarios.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="activo")
public class Activo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;//cód. TI serial number
  private String codinventario;//cód. Administración
  private String modelo;
  private String marca;
  private String procesador;
  private String tipodisco;
  private String capacidadDisco;
  private String memoria;
  private String nroserie;
  //formato default
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate fechaingreso;
  private String fechaIngresoStr;
  private String moneda;
  private BigDecimal importe;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Responsable responsable;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Tipo tipo;
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Grupo grupo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Articulo articulo;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "picture", columnDefinition = "bigint")
  private byte[] picture;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Proveedor proveedor;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodinventario() {
    return codinventario;
  }

  public void setCodinventario(String codinventario) {
    this.codinventario = codinventario;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getProcesador() {
    return procesador;
  }

  public void setProcesador(String procesador) {
    this.procesador = procesador;
  }

  public String getTipodisco() {
    return tipodisco;
  }

  public void setTipodisco(String tipodisco) {
    this.tipodisco = tipodisco;
  }

  public String getCapacidadDisco() {
    return capacidadDisco;
  }

  public void setCapacidadDisco(String capacidadDisco) {
    this.capacidadDisco = capacidadDisco;
  }

  public String getMemoria() {
    return memoria;
  }

  public void setMemoria(String memoria) {
    this.memoria = memoria;
  }

  public String getNroserie() {
    return nroserie;
  }

  public void setNroserie(String nroserie) {
    this.nroserie = nroserie;
  }

  public LocalDate getFechaingreso() {
    return fechaingreso;
  }

  public void setFechaingreso(LocalDate fechaingreso) {
    this.fechaingreso = fechaingreso;
  }

  public String getFechaIngresoStr() {
    return fechaIngresoStr;
  }

  public void setFechaIngresoStr(String fechaIngresoStr) {
    this.fechaIngresoStr = fechaIngresoStr;
  }

  public String getMoneda() {
    return moneda;
  }

  public void setMoneda(String moneda) {
    this.moneda = moneda;
  }

  public BigDecimal getImporte() {
    return importe;
  }

  public void setImporte(BigDecimal importe) {
    this.importe = importe;
  }

  public Responsable getResponsable() {
    return responsable;
  }

  public void setResponsable(Responsable responsable) {
    this.responsable = responsable;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public Grupo getGrupo() {
    return grupo;
  }

  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }

  public Articulo getArticulo() {
    return articulo;
  }

  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  public Proveedor getProveedor() {
    return proveedor;
  }

  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }
}