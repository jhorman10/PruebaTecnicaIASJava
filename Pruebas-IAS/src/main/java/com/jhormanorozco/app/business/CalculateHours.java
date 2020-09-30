package com.jhormanorozco.app.business;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.repository.TechnicianRepositoryCustom;

public class CalculateHours {

	Calendar cal = Calendar.getInstance();

	public int calculateExtraHours(Date endDate) {
		int hour = 20;
		cal.setTime(endDate);
		int end_date = cal.get(Calendar.HOUR_OF_DAY);

		if (end_date > hour) {
			return end_date - hour;
		} else {
			return 0;
		}
	}

	public int calculateNightHours(Date endDate) {
		cal.setTime(endDate);
		int end_date = cal.get(Calendar.HOUR_OF_DAY);
		int nightHourStart = 20;
		int nightHourFinish = 7;

		if (end_date > nightHourStart) {
			return end_date - nightHourStart;
		} else if (end_date < nightHourFinish) {
			return end_date + 4;
		} else {
			return 0;
		}

	}

	public int calculateDayOfWeek(Date startDate) {
		cal.setTime(startDate);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

	public int calculateWeekOfYear(Date startDate) {
		cal.setTime(startDate);
		int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
		return weekOfYear;
	}

	public List<ResponseDTO> calculateHoursForWeek(Long dni, Long n) throws Exception {
		TechnicianRepositoryCustom TRC = new TechnicianRepositoryCustom();
		return TRC.horasPorSemana(dni,n);
	}

	public int calculateHoursForDay(Date startDate, Date endDate) {
		cal.setTime(startDate);
		int start_Date = cal.get(Calendar.HOUR_OF_DAY);
		
		cal.setTime(endDate);
		int end_Date = cal.get(Calendar.HOUR_OF_DAY);
		return end_Date - start_Date;
	}
	
	public int calculateSaturday(Date startDate, Date endDate) {
		int day = calculateDayOfWeek(endDate);
		if (day == 6) {
			return calculateHoursForDay(startDate, endDate);
		}else {
			return 0;
		}
	}

	public int calculateSunday(Date startDate, Date endDate) {
		int day = calculateDayOfWeek(endDate);
		if (day == 7) {
			return calculateHoursForDay(startDate, endDate);
		}else {
			return 0;
		}
	}

	public int calculateSaturdayExtra(int hoursForWeek, Date endDate) {
		int day = calculateDayOfWeek(endDate);
		if (hoursForWeek > 48) {
			if (day == 6) {
				return calculateExtraHours(endDate);
			}
		}
		return 0;
	}

	public int calculateSundayExtra(int hoursForWeek, Date endDate) {
		int day = calculateDayOfWeek(endDate);
		if (hoursForWeek > 48) {
			if (day == 7) {
				return calculateExtraHours(endDate);
			}
		}
		return 0;
	}
	
	public int calculateSaturdayExtraNight(int hoursForWeek, Date endDate) {
		cal.setTime(endDate);
		int end_Date = cal.get(Calendar.HOUR_OF_DAY);
		int day = calculateDayOfWeek(endDate);
		if (end_Date > 20) {
			if (day == 6) {
				return calculateNightHours(endDate);
			}
		}
		return 0;
	}
	
	public int calculateSundayExtraNight(int hoursForWeek, Date endDate) {
		cal.setTime(endDate);
		int end_Date = cal.get(Calendar.HOUR_OF_DAY);
		int day = calculateDayOfWeek(endDate);
		if (end_Date > 20) {
			if (day == 7) {
				return calculateNightHours(endDate);
			}
		}
		return 0;
	}

}
