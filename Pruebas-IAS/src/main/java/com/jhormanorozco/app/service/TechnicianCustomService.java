package com.jhormanorozco.app.service;

import java.util.List;

import com.jhormanorozco.app.dto.PostRequestDTO;

public interface TechnicianCustomService {
	public List<PostRequestDTO> calculateHours(String startDate, String endDate, int dni, int serviceType);
}