package com.jhormanorozco.app.service;

import java.util.Date;
import java.util.List;

import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.dto.PostRequestDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;

public interface ITechnician_ServiceService {
	
	public List<ResponseDTO> obtenerHoras (Long dni, Long week) throws Exception;

	public PostDataDTO save(int dni, int serviceType, Date startDate, Date endDate) throws Exception;

	public Attention_Hour save(PostDataDTO post) throws Exception;

}
