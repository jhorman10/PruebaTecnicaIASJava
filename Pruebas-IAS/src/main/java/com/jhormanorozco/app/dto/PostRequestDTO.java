package com.jhormanorozco.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;


@Immutable
public class PostRequestDTO implements Serializable {

	private static final long serialVersionUID = 188989803936416806L;
	
	@Id
	@Column(name = "id_tecnico")
	private int id_tecnico;
	
	@Column(name = "tipo_servicio")
	private int tipo_servicio;
	
	@Column(name = "id_tecnico")
	private String fechaHoraInicio;
	
	@Column(name = "fechaHoraFin")
	private String fechaHoraFin;

	public int getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(int id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public int getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(int tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public String getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(String fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public String getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(String fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
	
}
