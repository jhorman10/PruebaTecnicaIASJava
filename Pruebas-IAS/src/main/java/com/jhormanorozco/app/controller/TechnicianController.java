package com.jhormanorozco.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhormanorozco.app.dto.PostRequestDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;
import com.jhormanorozco.app.service.Technician_ServiceService;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

	@Autowired
	private Technician_ServiceService technicianService;

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

	@PostMapping("/asha")
	public ResponseEntity<Attention_Hour> saveServicioAtentidoXTecnico(@RequestBody PostRequestDTO post) {
		List result = technicianService.hacerCalculos(post);
		Attention_Hour save = new Attention_Hour();
		save.setHORA_INICIO((Long) result.get(2));
		save.setHORA_FIN((Long) result.get(3));		
		return ResponseEntity.status(HttpStatus.OK).body(technicianService.save(save));
	}

}
