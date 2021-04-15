package com.jhormanorozco.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.jhormanorozco.app.dto.PostDataDTO;
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
    public ResponseEntity<String> getInfoServer() {
        return ResponseEntity.status(HttpStatus.OK).body("Funciona");
    }

    @GetMapping("/hours-for-week")
    public ResponseEntity getInformation(@RequestParam int dni, @RequestParam int n) throws Exception {

        var response = technicianService.obtenerHoras(dni, n);

        if (null == response) {
            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDTO>());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("/save-service")
    public ResponseEntity<Object> saveService(
            @RequestParam int dni, @RequestParam int serviceType,
            @RequestParam String startDate, @RequestParam String endDate
    ) throws Exception {
        try {
            Date nStart = DateTransformController.convertDate(startDate);
            Date nEnd = DateTransformController.convertDate(endDate);
            PostDataDTO response = HoursCalculatorController.calculateHours(dni, serviceType, nStart, nEnd);
            var total = technicianService.save(response);

//            if (total == null || total.isEmpty() || total.get(0) == null) {
//                return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDTO>());
//            } else {
                return ResponseEntity.status(HttpStatus.OK).body(total);
//            }

        } catch (Exception e) {
            throw new Exception("Error en método saveService controller: " + e);
        }
    }
}
