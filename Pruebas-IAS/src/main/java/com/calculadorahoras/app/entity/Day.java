package com.calculadorahoras.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIA")
public class Day implements Serializable {
	private static final long serialVersionUID = -1200719690416357961L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_DIA;
	
	@Column(nullable = false)
	private Long DIA_SEMANA;

	public Long getID_DIA() {
		return ID_DIA;
	}

	public void setID_DIA(Long iD_DIA) {
		ID_DIA = iD_DIA;
	}

	public Long getDIA_SEMANA() {
		return DIA_SEMANA;
	}

	public void setDIA_SEMANA(Long dIA_SEMANA) {
		DIA_SEMANA = dIA_SEMANA;
	}
}
