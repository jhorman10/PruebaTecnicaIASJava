package com.calculadorahoras.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.calculadorahoras.app.business.CalculateHoursBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.calculadorahoras.app.service.ITechnician_ServiceService;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    @Autowired
    private ITechnician_ServiceService technicianService;

    @GetMapping("/hours-for-week")
    public ResponseEntity getInformation(@RequestParam int dni, @RequestParam int n) throws Exception {
        try {
            var response = technicianService.obtenerHoras(dni, n);
            return ResponseEntity.status(HttpStatus.OK).body(Objects.requireNonNullElseGet(response, ArrayList::new));
        } catch (Exception e) {
            throw new Exception("Error en controller" + e);
        }
    }

    @PostMapping("/save-service")
    public ResponseEntity saveService(
            @RequestParam Date startDate, @RequestParam Date endDate,
            @RequestParam int dni, @RequestParam int serviceType) throws Exception {
        try {
            List totalHoras = technicianService.getTotalHoras(dni, CalculateHoursBusiness.calculateWeekOfYear(startDate));

            int horas = Integer.parseInt(totalHoras.get(0).toString());

            var response = technicianService.save(startDate, endDate, dni, serviceType, horas);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new Exception("Error en método saveService controller: " + e);
        }
    }
}
