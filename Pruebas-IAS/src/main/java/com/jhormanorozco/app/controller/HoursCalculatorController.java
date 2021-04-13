package com.jhormanorozco.app.controller;

import com.jhormanorozco.app.business.CalculateHoursBusiness;
import com.jhormanorozco.app.dto.PostDataDTO;
import java.util.Date;

public class HoursCalculatorController {

    @org.jetbrains.annotations.NotNull
    public static PostDataDTO calculateHours(long dni, int serviceType, Date startDate, Date endDate) throws Exception {
        PostDataDTO resp = new PostDataDTO();

        try{
            resp.setID_TECNICO((int) dni);
            resp.setDIA_SEMANA(CalculateHoursBusiness.calculateDayOfWeek(startDate));
            resp.setNUMERO_SEMANA(CalculateHoursBusiness.calculateWeekOfYear(startDate));
            long n = resp.getNUMERO_SEMANA();
            resp.setID_TECNICO((int) dni);
            resp.setID_TIPO_SERVICIO(serviceType);
            resp.setHORA_INICIO(CalculateHoursBusiness.calculateHour(startDate));
            resp.setHORA_FIN(CalculateHoursBusiness.calculateHour(endDate));
            resp.setHORA_NOCTURNA(CalculateHoursBusiness.calculateNightHours(endDate));
            resp.setHORA_EXTRA(CalculateHoursBusiness.calculateExtraHours(endDate));
            resp.setHORA_SABATINA(CalculateHoursBusiness.calculateSaturday(startDate, endDate));
            resp.setHORA_DOMINICAL(CalculateHoursBusiness.calculateSunday(startDate, endDate));
            resp.setTOTAL_HORAS(CalculateHoursBusiness.calculateHoursForDay(startDate, endDate));
            resp.setHORA_EXTRA_NOCTURNA(0);
            resp.setHORA_EXTRA_SABATINA(0);
            resp.setHORA_EXTRA_DOMINICAL(0);
            //resp.setHORA_EXTRA_NOCTURNA(CalculateHoursBusiness.calculateSaturdayExtraNight(endDate));
            ///resp.setHORA_EXTRA_SABATINA(CalculateHoursBusiness.calculateSaturdayExtra(CalculateHoursBusiness.calculateHoursForWeek(dni, n), endDate));
            //resp.setHORA_EXTRA_DOMINICAL(CalculateHoursBusiness.calculateSundayExtra(CalculateHoursBusiness.calculateHoursForWeek(dni, n), endDate));

            return resp;
        }catch (Exception e){
            throw new Exception("Error al convertir el objeto en la clase HoursCalculatorController: "+ e);
        }
    }
}
