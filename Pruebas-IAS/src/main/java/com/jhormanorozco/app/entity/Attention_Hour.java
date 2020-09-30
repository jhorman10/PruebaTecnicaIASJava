package com.jhormanorozco.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "HORA_ATENCION")
public class Attention_Hour implements Serializable {

	private static final long serialVersionUID = -2857411631705128403L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_HORA_ATENCION;

	@Column(nullable = false)
	private Long HORA_INICIO;

	@Column(nullable = false)
	private Long HORA_FIN;

	@Column(nullable = false)
	private Long HORA_NOCTURNA;

	@Column(nullable = false)
	private Long HORA_SABATINA;

	@Column(nullable = false)
	private Long HORA_DOMINICAL;

	@Column(nullable = false)
	private Long HORA_EXTRA;

	@Column(nullable = false)
	private Long HORA_EXTRA_NOCTURNA;

	@Column(nullable = false)
	private Long HORA_EXTRA_SABATINA;

	@Column(nullable = false)
	private Long HORA_EXTRA_DOMINICAL;

	@Column(nullable = false)
	private Long TOTAL_HORAS;

	public Long getID_HORA_ATENCION() {
		return ID_HORA_ATENCION;
	}

	public void setID_HORA_ATENCION(Long iD_HORA_ATENCION) {
		ID_HORA_ATENCION = iD_HORA_ATENCION;
	}

	public Long getHORA_INICIO() {
		return HORA_INICIO;
	}

	public void setHORA_INICIO(Long hORA_INICIO) {
		HORA_INICIO = hORA_INICIO;
	}

	public Long getHORA_FIN() {
		return HORA_FIN;
	}

	public void setHORA_FIN(Long hORA_FIN) {
		HORA_FIN = hORA_FIN;
	}

	public Long getHORA_NOCTURNA() {
		return HORA_NOCTURNA;
	}

	public void setHORA_NOCTURNA(Long hORA_NOCTURNA) {
		HORA_NOCTURNA = hORA_NOCTURNA;
	}

	public Long getHORA_SABATINA() {
		return HORA_SABATINA;
	}

	public void setHORA_SABATINA(Long hORA_SABATINA) {
		HORA_SABATINA = hORA_SABATINA;
	}

	public Long getHORA_DOMINICAL() {
		return HORA_DOMINICAL;
	}

	public void setHORA_DOMINICAL(Long hORA_DOMINICAL) {
		HORA_DOMINICAL = hORA_DOMINICAL;
	}

	public Long getHORA_EXTRA() {
		return HORA_EXTRA;
	}

	public void setHORA_EXTRA(Long hORA_EXTRA) {
		HORA_EXTRA = hORA_EXTRA;
	}

	public Long getHORA_EXTRA_NOCTURNA() {
		return HORA_EXTRA_NOCTURNA;
	}

	public void setHORA_EXTRA_NOCTURNA(Long hORA_EXTRA_NOCTURNA) {
		HORA_EXTRA_NOCTURNA = hORA_EXTRA_NOCTURNA;
	}

	public Long getHORA_EXTRA_SABATINA() {
		return HORA_EXTRA_SABATINA;
	}

	public void setHORA_EXTRA_SABATINA(Long hORA_EXTRA_SABATINA) {
		HORA_EXTRA_SABATINA = hORA_EXTRA_SABATINA;
	}

	public Long getHORA_EXTRA_DOMINICAL() {
		return HORA_EXTRA_DOMINICAL;
	}

	public void setHORA_EXTRA_DOMINICAL(Long hORA_EXTRA_DOMINICAL) {
		HORA_EXTRA_DOMINICAL = hORA_EXTRA_DOMINICAL;
	}

	public Long getTOTAL_HORAS() {
		return TOTAL_HORAS;
	}

	public void setTOTAL_HORAS(Long tOTAL_HORAS) {
		TOTAL_HORAS = tOTAL_HORAS;
	}

}
