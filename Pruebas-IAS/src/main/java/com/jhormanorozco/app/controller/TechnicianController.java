package com.jhormanorozco.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhormanorozco.app.dto.PostRequestDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.service.TechnicianCustomService;
import com.jhormanorozco.app.service.Technician_ServiceService;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

	@Autowired
	private Technician_ServiceService technicianService;
	private TechnicianCustomService technicianCustomService;

	@GetMapping("/hours-for-week")
	public ResponseEntity<List<ResponseDTO>> getInformation(@RequestParam Long dni, @RequestParam Long n)
			throws Exception {
		List<ResponseDTO> response = technicianService.obtenerHoras(dni, n);
		if (response == null || response.isEmpty() || response.get(0) == null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDTO>());
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@PostMapping("/save-service")
	public ResponseEntity<List<PostRequestDTO>> saveServicioAtentidoXTecnico(@RequestParam int dni,
			@RequestParam int serviceType, @RequestParam String startDate, @RequestParam String endDate) {
		System.out.println("DNI: " + dni + " " + "serviceType: " + serviceType + " " + "startDate: " + startDate + " "
				+ "endDate: " + endDate);
		return ResponseEntity.status(HttpStatus.OK)
				.body(technicianCustomService.calculateHours(startDate, endDate, dni, serviceType));
	}

}
