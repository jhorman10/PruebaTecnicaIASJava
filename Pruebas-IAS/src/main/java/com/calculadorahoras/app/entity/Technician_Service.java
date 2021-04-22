package com.calculadorahoras.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TECNICO_SERVICIO")
public class Technician_Service implements Serializable {
	private static final long serialVersionUID = -3874835351775457406L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	ID_TECNICO_SERVICIO;
	
	@Column(nullable = false)
	private Long ID_TECNICO;
	
	@Column(nullable = false)
	private Long ID_SERVICIO;
	
	@Column(nullable = false)
	private Long ID_SEMANA ;
	
	public Long getID_TECNICO_SERVICIO() {
		return ID_TECNICO_SERVICIO;
	}

	public void setID_TECNICO_SERVICIO(Long iD_TECNICO_SERVICIO) {
		ID_TECNICO_SERVICIO = iD_TECNICO_SERVICIO;
	}

	public Long getID_TECNICO() {
		return ID_TECNICO;
	}

	public void setID_TECNICO(Long iD_TECNICO) {
		ID_TECNICO = iD_TECNICO;
	}

	public Long getID_SERVICIO() {
		return ID_SERVICIO;
	}

	public void setID_SERVICIO(Long iD_SERVICIO) {
		ID_SERVICIO = iD_SERVICIO;
	}

	public Long getID_SEMANA() {
		return ID_SEMANA;
	}

	public void setID_SEMANA(Long iD_SEMANA) {
		ID_SEMANA = iD_SEMANA;
	}

}
