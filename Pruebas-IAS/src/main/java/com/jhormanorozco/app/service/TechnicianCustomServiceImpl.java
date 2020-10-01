package com.jhormanorozco.app.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jhormanorozco.app.business.CalculateHours;
import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.dto.PostRequestDTO;

@Service
public class TechnicianCustomServiceImpl {

	public CalculateHours calculateHours;
	
	public static List<PostDataDTO> calculateHours(Date startDate, Date endDate, int dni, int serviceType) throws Exception {
		List<PostDataDTO> resp = null;
		resp.get(0).setDIA_SEMANA(CalculateHours.calculateDayOfWeek(startDate));
		int n = resp.get(0).getNUMERO_SEMANA();
		resp.get(0).setNUMERO_SEMANA(CalculateHours.calculateWeekOfYear(startDate));
		resp.get(0).setID_TECNICO(dni);
		resp.get(0).setID_TIPO_SERVICIO(serviceType);
		resp.get(0).setHORA_NOCTURNA(CalculateHours.calculateNightHours(endDate));
		resp.get(0).setHORA_EXTRA(CalculateHours.calculateExtraHours(endDate));
		resp.get(0).setHORA_SABATINA(CalculateHours.calculateSaturday(startDate, endDate));
		resp.get(0).setHORA_DOMINICAL(CalculateHours.calculateSunday(startDate, endDate));
		resp.get(0).setHORA_EXTRA_NOCTURNA(CalculateHours.calculateSaturdayExtraNight(CalculateHours.calculateHoursForWeek(dni, n), endDate));
		resp.get(0).setHORA_EXTRA_SABATINA(CalculateHours.calculateSaturdayExtra(CalculateHours.calculateHoursForWeek(dni, n), endDate));
		resp.get(0).setHORA_EXTRA_DOMINICAL(CalculateHours.calculateSundayExtra(CalculateHours.calculateHoursForWeek(dni, n), endDate));
		return resp;
	}
}
