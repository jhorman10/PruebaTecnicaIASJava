package com.jhormanorozco.app.service;

import java.util.List;

import com.jhormanorozco.app.dto.PostDataDTO;

public interface TechnicianCustomService {
	public List<PostDataDTO> calculateHours(String startDate, String endDate, int dni, int serviceType);
}