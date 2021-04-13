package com.jhormanorozco.app.service;

import java.util.Date;
import java.util.List;

import com.jhormanorozco.app.controller.HoursCalculatorController;
import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.dto.PostRequestDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhormanorozco.app.repository.Technician_RepositoryIMPL;

@Service
public class Technician_ServiceServiceIMPL implements ITechnician_ServiceService {

	@Autowired
	private Technician_RepositoryIMPL technicianRepository;

	@Override
	public List obtenerHoras(Long dni, Long week) throws Exception {
		return technicianRepository.horasPorSemana(dni, week);
	}

	@Override
	public PostDataDTO save(int dni, int serviceType, Date startDate, Date endDate) throws Exception {
		return HoursCalculatorController.calculateHours(dni, serviceType, startDate, endDate);
	}

	@Override
	public Attention_Hour save(PostDataDTO post) throws Exception {
		return technicianRepository.save(post);
	}

	@Override
	public List<ResponseDTO> hacerCalculos(PostRequestDTO post) {
		return null;
	}

}
