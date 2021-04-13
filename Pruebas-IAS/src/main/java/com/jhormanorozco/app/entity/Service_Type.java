package com.jhormanorozco.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_SERVICIO")
public class Service_Type implements Serializable {
	private static final long serialVersionUID = 6496876985708944209L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_TIPO_SERVICIO;
	
	@Column(length = 50, nullable = false, unique = true)
	private String TIPO;

	public Long getID_TIPO_SERVICIO() {
		return ID_TIPO_SERVICIO;
	}

	public void setID_TIPO_SERVICIO(Long iD_TIPO_SERVICIO) {
		ID_TIPO_SERVICIO = iD_TIPO_SERVICIO;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	
}
