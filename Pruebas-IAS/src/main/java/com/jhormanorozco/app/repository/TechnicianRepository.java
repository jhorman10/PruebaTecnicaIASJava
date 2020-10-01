package com.jhormanorozco.app.repository;

import java.util.List;

import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;

public interface TechnicianRepository{
	
	//@Query("SELECT t FROM Technician t WHERE t.dni = ?1")
	public List<ResponseDTO> horasPorSemana(Long dni, Long n) throws Exception;

	List<ResponseDTO> horasPorSemana1(Long dni, Long n);
	
	Attention_Hour save(Attention_Hour post);

	Attention_Hour save(int HORA_INICIO, int HORA_FIN, int HORA_NOCTURNA, int HORA_SABATINA, int HORA_DOMINICAL,
			int HORA_EXTRA, int HORA_EXTRA_NOCTURNA, int HORA_EXTRA_SABATINA, int HORA_EXTRA_DOMINICAL, int TOTAL_HORAS,
			int ID_TECNICO) throws Exception;

	List<ResponseDTO> horasPorSemana(int dni, int n) throws Exception;

}

