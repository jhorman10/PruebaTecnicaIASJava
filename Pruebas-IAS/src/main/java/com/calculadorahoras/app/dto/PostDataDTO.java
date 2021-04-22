package com.calculadorahoras.app.dto;

import org.hibernate.annotations.Immutable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Immutable
public class PostDataDTO implements Serializable {

    private static final long serialVersionUID = 188989803936416806L;

    @Id
    @Column(name = "ID_TECNICO")
    private int ID_TECNICO;

    @Column(name = "ID_TIPO_SERVICIO")
    private int ID_TIPO_SERVICIO;

    @Column(name = "NUMERO_SEMANA")
    private int NUMERO_SEMANA;

    @Column(name = "DIA_SEMANA")
    private int DIA_SEMANA;

    @Column(name = "HORA_INICIO")
    private int HORA_INICIO;

    @Column(name = "HORA_FIN")
    private int HORA_FIN;

    @Column(name = "HORA_NOCTURNA")
    private int HORA_NOCTURNA;

    @Column(name = "HORA_SABATINA")
    private int HORA_SABATINA;

    @Column(name = "HORA_DOMINICAL")
    private int HORA_DOMINICAL;

    @Column(name = "HORA_EXTRA")
    private int HORA_EXTRA;

    @Column(name = "HORA_EXTRA_NOCTURNA")
    private int HORA_EXTRA_NOCTURNA;

    @Column(name = "HORA_EXTRA_SABATINA")
    private int HORA_EXTRA_SABATINA;

    @Column(name = "HORA_EXTRA_DOMINICAL")
    private int HORA_EXTRA_DOMINICAL;

    @Column(name = "TOTAL_HORAS")
    private int TOTAL_HORAS;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getID_TECNICO() {
        return ID_TECNICO;
    }

    public void setID_TECNICO(int ID_TECNICO) {
        this.ID_TECNICO = ID_TECNICO;
    }

    public int getID_TIPO_SERVICIO() {
        return ID_TIPO_SERVICIO;
    }

    public void setID_TIPO_SERVICIO(int ID_TIPO_SERVICIO) {
        this.ID_TIPO_SERVICIO = ID_TIPO_SERVICIO;
    }

    public int getNUMERO_SEMANA() {
        return NUMERO_SEMANA;
    }

    public void setNUMERO_SEMANA(int NUMERO_SEMANA) {
        this.NUMERO_SEMANA = NUMERO_SEMANA;
    }

    public int getDIA_SEMANA() {
        return DIA_SEMANA;
    }

    public void setDIA_SEMANA(int DIA_SEMANA) {
        this.DIA_SEMANA = DIA_SEMANA;
    }

    public int getHORA_INICIO() {
        return HORA_INICIO;
    }

    public void setHORA_INICIO(int HORA_INICIO) {
        this.HORA_INICIO = HORA_INICIO;
    }

    public int getHORA_FIN() {
        return HORA_FIN;
    }

    public void setHORA_FIN(int HORA_FIN) {
        this.HORA_FIN = HORA_FIN;
    }

    public int getHORA_NOCTURNA() {
        return HORA_NOCTURNA;
    }

    public void setHORA_NOCTURNA(int HORA_NOCTURNA) {
        this.HORA_NOCTURNA = HORA_NOCTURNA;
    }

    public int getHORA_SABATINA() {
        return HORA_SABATINA;
    }

    public void setHORA_SABATINA(int HORA_SABATINA) {
        this.HORA_SABATINA = HORA_SABATINA;
    }

    public int getHORA_DOMINICAL() {
        return HORA_DOMINICAL;
    }

    public void setHORA_DOMINICAL(int HORA_DOMINICAL) {
        this.HORA_DOMINICAL = HORA_DOMINICAL;
    }

    public int getHORA_EXTRA() {
        return HORA_EXTRA;
    }

    public void setHORA_EXTRA(int HORA_EXTRA) {
        this.HORA_EXTRA = HORA_EXTRA;
    }

    public int getHORA_EXTRA_NOCTURNA() {
        return HORA_EXTRA_NOCTURNA;
    }

    public void setHORA_EXTRA_NOCTURNA(int HORA_EXTRA_NOCTURNA) {
        this.HORA_EXTRA_NOCTURNA = HORA_EXTRA_NOCTURNA;
    }

    public int getHORA_EXTRA_SABATINA() {
        return HORA_EXTRA_SABATINA;
    }

    public void setHORA_EXTRA_SABATINA(int HORA_EXTRA_SABATINA) {
        this.HORA_EXTRA_SABATINA = HORA_EXTRA_SABATINA;
    }

    public int getHORA_EXTRA_DOMINICAL() {
        return HORA_EXTRA_DOMINICAL;
    }

    public void setHORA_EXTRA_DOMINICAL(int HORA_EXTRA_DOMINICAL) {
        this.HORA_EXTRA_DOMINICAL = HORA_EXTRA_DOMINICAL;
    }

    public int getTOTAL_HORAS() {
        return TOTAL_HORAS;
    }

    public void setTOTAL_HORAS(int TOTAL_HORAS) {
        this.TOTAL_HORAS = TOTAL_HORAS;
    }
}
