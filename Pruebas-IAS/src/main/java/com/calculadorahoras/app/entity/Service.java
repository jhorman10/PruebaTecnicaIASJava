package com.calculadorahoras.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICIO")
public class Service implements Serializable {
	private static final long serialVersionUID = 980726550341007176L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_SERVICIO;

	@Column(nullable = false)
	private Long ID_TIPO_SERVICIO;

	public Long getID_SERVICIO() {
		return ID_SERVICIO;
	}

	public void setID_SERVICIO(Long iD_SERVICIO) {
		ID_SERVICIO = iD_SERVICIO;
	}

	public Long getID_TIPO_SERVICIO() {
		return ID_TIPO_SERVICIO;
	}

	public void setID_TIPO_SERVICIO(Long iD_TIPO_SERVICIO) {
		ID_TIPO_SERVICIO = iD_TIPO_SERVICIO;
	}
	
}
