package com.jhormanorozco.app.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class PostDataDTO {
	
	@Id
	@Column(name="ID_TECNICO")
	private int ID_TECNICO;
	
	@Column(name="ID_TIPO_SERVICIO")
	private int ID_TIPO_SERVICIO;
	
	@Column(name="NUMERO_SEMANA")
	private int NUMERO_SEMANA;
	
	@Column(name="DIA_SEMANA")
	private int DIA_SEMANA;
	
	@Column(name="HORA_INICIO")
	private int HORA_INICIO;
	
	@Column(name="HORA_FIN")
	private int HORA_FIN;
	
	@Column(name="HORA_NOCTURNA")
	private int HORA_NOCTURNA;
	
	@Column(name="HORA_SABATINA")
	private int HORA_SABATINA;
	
	@Column(name="HORA_DOMINICAL")
	private int HORA_DOMINICAL;
	
	@Column(name="HORA_EXTRA")
	private int HORA_EXTRA;
	
	@Column(name="HORA_EXTRA_NOCTURNA")
	private int HORA_EXTRA_NOCTURNA;
	
	@Column(name="HORA_EXTRA_SABATINA")
	private int HORA_EXTRA_SABATINA;
	
	@Column(name="HORA_EXTRA_DOMINICAL")
	private int HORA_EXTRA_DOMINICAL;
	
	@Column(name="TOTAL_HORAS")
	private int TOTAL_HORAS;

	public int getID_TECNICO() {
		return ID_TECNICO;
	}

	public void setID_TECNICO(int iD_TECNICO) {
		ID_TECNICO = iD_TECNICO;
	}

	public int getID_TIPO_SERVICIO() {
		return ID_TIPO_SERVICIO;
	}

	public void setID_TIPO_SERVICIO(int iD_TIPO_SERVICIO) {
		ID_TIPO_SERVICIO = iD_TIPO_SERVICIO;
	}

	public int getNUMERO_SEMANA() {
		return NUMERO_SEMANA;
	}

	public void setNUMERO_SEMANA(int nUMERO_SEMANA) {
		NUMERO_SEMANA = nUMERO_SEMANA;
	}

	public int getDIA_SEMANA() {
		return DIA_SEMANA;
	}

	public void setDIA_SEMANA(int dIA_SEMANA) {
		DIA_SEMANA = dIA_SEMANA;
	}

	public int getHORA_INICIO() {
		return HORA_INICIO;
	}

	public void setHORA_INICIO(int hORA_INICIO) {
		HORA_INICIO = hORA_INICIO;
	}

	public int getHORA_FIN() {
		return HORA_FIN;
	}

	public void setHORA_FIN(int hORA_FIN) {
		HORA_FIN = hORA_FIN;
	}

	public int getHORA_NOCTURNA() {
		return HORA_NOCTURNA;
	}

	public void setHORA_NOCTURNA(int hORA_NOCTURNA) {
		HORA_NOCTURNA = hORA_NOCTURNA;
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

	public int getHORA_EXTRA() {
		return HORA_EXTRA;
	}

	public void setHORA_EXTRA(int hORA_EXTRA) {
		HORA_EXTRA = hORA_EXTRA;
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

	public int getHORA_EXTRA_DOMINICAL() {
		return HORA_EXTRA_DOMINICAL;
	}

	public void setHORA_EXTRA_DOMINICAL(int hORA_EXTRA_DOMINICAL) {
		HORA_EXTRA_DOMINICAL = hORA_EXTRA_DOMINICAL;
	}

	public int getTOTAL_HORAS() {
		return TOTAL_HORAS;
	}

	public void setTOTAL_HORAS(int tOTAL_HORAS) {
		TOTAL_HORAS = tOTAL_HORAS;
	}
	
}
