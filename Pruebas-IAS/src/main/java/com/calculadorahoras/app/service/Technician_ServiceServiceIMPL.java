package com.calculadorahoras.app.service;

import java.util.Date;
import java.util.List;

import com.calculadorahoras.app.business.CalculateHoursBusiness;
import com.calculadorahoras.app.dto.PostDataDTO;
import com.calculadorahoras.app.repository.ITechnician_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Technician_ServiceServiceIMPL implements ITechnician_ServiceService {

    @Autowired
    private ITechnician_Repository technicianRepository;

    @Override
    public List getTotalHoras(int dni, int week) throws Exception {
        return technicianRepository.getTotalHoras(dni, week);
    }

    @Override
    public List obtenerHoras(int dni, int week) throws Exception {
        return technicianRepository.horasPorSemana(dni, week);
    }

    @Override
    public List save(Date startDate, Date endDate, int dni, int serviceType, int tHoras) throws Exception {

        PostDataDTO resp = new PostDataDTO();
        resp.setID_TECNICO(dni);
        resp.setDIA_SEMANA(CalculateHoursBusiness.calculateDayOfWeek(startDate));
        resp.setNUMERO_SEMANA(CalculateHoursBusiness.calculateWeekOfYear(startDate));
        int n = resp.getNUMERO_SEMANA();
        resp.setID_TIPO_SERVICIO(serviceType);
        resp.setHORA_INICIO(CalculateHoursBusiness.calculateHour(startDate));
        resp.setHORA_FIN(CalculateHoursBusiness.calculateHour(endDate));
        resp.setHORA_NOCTURNA(CalculateHoursBusiness.calculateNightHours(endDate));
        resp.setHORA_SABATINA(CalculateHoursBusiness.calculateSaturday(startDate, endDate));
        resp.setHORA_DOMINICAL(CalculateHoursBusiness.calculateSunday(startDate, endDate));
        resp.setTOTAL_HORAS(CalculateHoursBusiness.calculateHoursForDay(startDate, endDate));
        resp.setHORA_EXTRA(CalculateHoursBusiness.calculateExtraHours(tHoras, endDate));
        resp.setHORA_EXTRA_NOCTURNA(CalculateHoursBusiness.calculateSaturdayExtraNight(tHoras, endDate));
        resp.setHORA_EXTRA_SABATINA(CalculateHoursBusiness.calculateSaturdayExtra(tHoras, endDate));
        resp.setHORA_EXTRA_DOMINICAL(CalculateHoursBusiness.calculateSundayExtra(tHoras, endDate));

        return technicianRepository.save(resp);
    }
}
