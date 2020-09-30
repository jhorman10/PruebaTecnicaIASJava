package com.jhormanorozco.app.service;

import java.util.List;

import com.jhormanorozco.app.dto.PostRequestDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;

public interface Technician_ServiceService {
	
	public List<ResponseDTO> obtenerHoras (Long dni, Long week) throws Exception;

	public Attention_Hour save(Attention_Hour save);

	public List<Object> hacerCalculos(PostRequestDTO post);

}
