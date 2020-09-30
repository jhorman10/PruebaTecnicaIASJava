package com.jhormanorozco.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhormanorozco.app.repository.TechnicianRepository;

@Service
public class TechnicianServiceImpl implements TechnicianService {

	@Autowired
	private TechnicianRepository TechnicianRepository;
}
