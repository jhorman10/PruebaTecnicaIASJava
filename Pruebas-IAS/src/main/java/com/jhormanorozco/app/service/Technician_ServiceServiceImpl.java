package com.jhormanorozco.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhormanorozco.app.dto.PostRequestDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;
import com.jhormanorozco.app.repository.TechnicianRepositoryCustom;

@Service
public class Technician_ServiceServiceImpl implements Technician_ServiceService {

	@Autowired
	private TechnicianRepositoryCustom technicianRepository;

	@Override
	public List<ResponseDTO> obtenerHoras(Long dni, Long week) throws Exception {
		return technicianRepository.horasPorSemana(dni, week);
	}

	@Override
	public Attention_Hour save(Attention_Hour post) {
		return (Attention_Hour) technicianRepository.save(post);
	}

	@Override
	public List<Object> hacerCalculos(PostRequestDTO post) {
		// auqui se calcula
		List<Object> list = new ArrayList<>();
		list.add(post.getId_tecnico());
		list.add(post.getTipo_servicio());
		list.add(post.getFechaHoraInicio());
		list.add(post.getFechaHoraFin());
		return list;
	}

}
