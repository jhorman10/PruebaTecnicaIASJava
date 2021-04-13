package com.jhormanorozco.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TECNICO")
public class Technician implements Serializable {
	private static final long serialVersionUID = 1586669230056609116L;

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CC_TECNICO;*/
	@Id
	@Column(name="CC_TECNICO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dni;

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

}
