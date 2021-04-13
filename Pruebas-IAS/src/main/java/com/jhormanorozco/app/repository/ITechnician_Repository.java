package com.jhormanorozco.app.repository;

import java.util.List;

import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;

public interface ITechnician_Repository {
	
	List<ResponseDTO> horasPorSemana(Long dni, Long n) throws Exception;

	int totalHoras(long dni, int n) throws Exception;

	Attention_Hour save(PostDataDTO post) throws Exception;

	Attention_Hour save(int HORA_INICIO, int HORA_FIN, int HORA_NOCTURNA, int HORA_SABATINA, int HORA_DOMINICAL,
			int HORA_EXTRA, int HORA_EXTRA_NOCTURNA, int HORA_EXTRA_SABATINA, int HORA_EXTRA_DOMINICAL, int TOTAL_HORAS,
			int ID_TECNICO) throws Exception;
}

