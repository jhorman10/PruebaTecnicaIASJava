package com.jhormanorozco.app.dto;

import java.util.Date;

import org.hibernate.annotations.Immutable;


@Immutable
public class PostRequestDTO {

	private Long id_tecnico;
	private Long tipo_servicio;
	private Date fechaHoraInicio;
	private Date fechaHoraFin;

	public Long getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(Long id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public Long getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(Long tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Date getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(Date fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

}
