package com.jhormanorozco.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.entity.Attention_Hour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.service.ITechnician_ServiceService;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

	@Autowired
	private ITechnician_ServiceService technicianService;

	@GetMapping()
	public ResponseEntity<String> getInfoServer(){
		return ResponseEntity.status(HttpStatus.OK).body("Funciona");
	}

	@GetMapping("/hours-for-week")
	public ResponseEntity<List<ResponseDTO>> getInformation(@RequestParam Long dni, @RequestParam Long n) throws Exception {

		List<ResponseDTO> response = technicianService.obtenerHoras(dni, n);

		if (response == null || response.isEmpty() || response.get(0) == null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDTO>());
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@PostMapping("/save-service")
	public ResponseEntity<Attention_Hour> saveService(
			@RequestParam int dni, @RequestParam int serviceType, @RequestParam String startDate, @RequestParam String endDate
			) throws Exception {

		Date nStart = new DateTransformController().convertDate(startDate);
		Date nEnd = new DateTransformController().convertDate(endDate);

		PostDataDTO response = (PostDataDTO) HoursCalculatorController.calculateHours(dni, serviceType, nStart, nEnd);
		Attention_Hour total = technicianService.save(response);
		//Attention_Hour response = technicianService.save(dni, serviceType, nStart, nEnd);

		return ResponseEntity.status(HttpStatus.OK).body(total);
		//return null;
	}

}
