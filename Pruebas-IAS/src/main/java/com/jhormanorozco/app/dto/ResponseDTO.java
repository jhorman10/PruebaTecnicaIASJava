package com.jhormanorozco.app.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class ResponseDTO implements Serializable {

    private static final long serialVersionUID = 3505786372729687021L;

    @Id
    @Column(name = "ID_TECNICO")
    private int ID_TECNICO;

    @Column(name = "NUMERO_SEMANA")
    private int NUMERO_SEMANA;

    @Column(name = "HORA_EXTRA")
    private int HORA_EXTRA;

    @Column(name = "HORA_SABATINA")
    private int HORA_SABATINA;

    @Column(name = "HORA_DOMINICAL")
    private int HORA_DOMINICAL;

    @Column(name = "HORA_EXTRA_NOCTURNA")
    private int HORA_EXTRA_NOCTURNA;

    @Column(name = "HORA_EXTRA_SABATINA")
    private int HORA_EXTRA_SABATINA;

    @Column(name = "TOTAL_HORAS")
    private int TOTAL_HORAS;

    public int getID_TECNICO() {
        return ID_TECNICO;
    }

    public void setID_TECNICO(int iD_TECNICO) {
        ID_TECNICO = iD_TECNICO;
    }

    public int getNUMERO_SEMANA() {
        return NUMERO_SEMANA;
    }

    public void setNUMERO_SEMANA(int nUMERO_SEMANA) {
        NUMERO_SEMANA = nUMERO_SEMANA;
    }

    public int getHORA_EXTRA() {
        return HORA_EXTRA;
    }

    public void setHORA_EXTRA(int hORA_EXTRA) {
        HORA_EXTRA = hORA_EXTRA;
    }

    public int getHORA_SABATINA() {
        return HORA_SABATINA;
    }

    public void setHORA_SABATINA(int hORA_SABATINA) {
        HORA_SABATINA = hORA_SABATINA;
    }

    public int getHORA_DOMINICAL() {
        return HORA_DOMINICAL;
    }

    public void setHORA_DOMINICAL(int hORA_DOMINICAL) {
        HORA_DOMINICAL = hORA_DOMINICAL;
    }

    public int getHORA_EXTRA_NOCTURNA() {
        return HORA_EXTRA_NOCTURNA;
    }

    public void setHORA_EXTRA_NOCTURNA(int hORA_EXTRA_NOCTURNA) {
        HORA_EXTRA_NOCTURNA = hORA_EXTRA_NOCTURNA;
    }

    public int getHORA_EXTRA_SABATINA() {
        return HORA_EXTRA_SABATINA;
    }

    public void setHORA_EXTRA_SABATINA(int hORA_EXTRA_SABATINA) {
        HORA_EXTRA_SABATINA = hORA_EXTRA_SABATINA;
    }

    public int getTOTAL_HORAS() {
        return TOTAL_HORAS;
    }

    public void setTOTAL_HORAS(int tOTAL_HORAS) {
        TOTAL_HORAS = tOTAL_HORAS;
    }
}
