package com.jhormanorozco.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SEMANA")
public class Week implements Serializable {

	private static final long serialVersionUID = 3549249879076834209L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_SEMANA;
	
	@Column(nullable = false)
	private Long NUMERO_SEMANA;

	public Long getID_SEMANA() {
		return ID_SEMANA;
	}

	public void setID_SEMANA(Long iD_SEMANA) {
		ID_SEMANA = iD_SEMANA;
	}

	public Long getNUMERO_SEMANA() {
		return NUMERO_SEMANA;
	}

	public void setNUMERO_SEMANA(Long nUMERO_SEMANA) {
		NUMERO_SEMANA = nUMERO_SEMANA;
	}
}
