package com.jhormanorozco.app.repository;

import java.util.List;

import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;

public interface TechnicianRepository{
	
	//@Query("SELECT t FROM Technician t WHERE t.dni = ?1")
	public List<ResponseDTO> horasPorSemana(Long dni, Long n) throws Exception;

	List<ResponseDTO> horasPorSemana1(Long dni, Long n);
	
	Attention_Hour save(Attention_Hour post);

}

