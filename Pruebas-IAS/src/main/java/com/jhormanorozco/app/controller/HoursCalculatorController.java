package com.jhormanorozco.app.controller;

import com.jhormanorozco.app.business.CalculateHoursBusiness;
import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.dto.TotalHorasDTO;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.List;

@Controller
public class HoursCalculatorController {

    public static PostDataDTO calculateHours(int dni, int serviceType, Date startDate, Date endDate) throws Exception {
        try {
            PostDataDTO resp = new PostDataDTO();
            resp.setID_TECNICO(dni);
            resp.setDIA_SEMANA(CalculateHoursBusiness.calculateDayOfWeek(startDate));
            resp.setNUMERO_SEMANA(CalculateHoursBusiness.calculateWeekOfYear(startDate));
            int n = resp.getNUMERO_SEMANA();
            //List totalHoras = CalculateHoursBusiness.calculateHoursForWeek(dni, n);
            resp.setID_TECNICO(dni);
            resp.setID_TIPO_SERVICIO(serviceType);
            resp.setHORA_INICIO(CalculateHoursBusiness.calculateHour(startDate));
            resp.setHORA_FIN(CalculateHoursBusiness.calculateHour(endDate));
            resp.setHORA_NOCTURNA(CalculateHoursBusiness.calculateNightHours(endDate));
            resp.setHORA_SABATINA(CalculateHoursBusiness.calculateSaturday(startDate, endDate));
            resp.setHORA_DOMINICAL(CalculateHoursBusiness.calculateSunday(startDate, endDate));
            resp.setTOTAL_HORAS(CalculateHoursBusiness.calculateHoursForDay(startDate, endDate));
            resp.setHORA_EXTRA_NOCTURNA(0);
            resp.setHORA_EXTRA_SABATINA(0);
            resp.setHORA_EXTRA_DOMINICAL(0);
            resp.setHORA_EXTRA(0);
//            resp.setHORA_EXTRA(CalculateHoursBusiness.calculateExtraHours(totalHoras, endDate));
//            resp.setHORA_EXTRA_NOCTURNA(CalculateHoursBusiness.calculateSaturdayExtraNight(totalHoras, endDate));
//            resp.setHORA_EXTRA_SABATINA(CalculateHoursBusiness.calculateSaturdayExtra(totalHoras, endDate));
//            resp.setHORA_EXTRA_DOMINICAL(CalculateHoursBusiness.calculateSundayExtra(totalHoras, endDate));

            return resp;
        } catch (Exception e) {
            throw new Exception("Error al convertir el objeto en la clase HoursCalculatorController: " + e);
        }
    }
}
