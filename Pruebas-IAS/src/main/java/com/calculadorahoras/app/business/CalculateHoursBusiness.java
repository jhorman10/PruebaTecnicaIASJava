package com.calculadorahoras.app.business;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import com.calculadorahoras.app.repository.Technician_RepositoryIMPL;

public class CalculateHoursBusiness {

    static Calendar cal = Calendar.getInstance();

    public static int calculateHour(Date date) {
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int calculateExtraHours(int total, Date endDate) {
        cal.setTime(endDate);
        int end_date = cal.get(Calendar.HOUR_OF_DAY);

        if (end_date > total) {
            return total - end_date;
        } else {
            return 0;
        }
    }

    public static int calculateNightHours(Date endDate) {
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

    public static int calculateDayOfWeek(Date startDate) {
        cal.setTime(startDate);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int calculateWeekOfYear(Date startDate) {
        cal.setTime(startDate);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static List calculateHoursForWeek(int dni, int n) throws Exception {
        Technician_RepositoryIMPL TRC = new Technician_RepositoryIMPL();
        return TRC.getTotalHoras(dni, n);
    }

    public static int calculateHoursForDay(Date startDate, Date endDate) {
        cal.setTime(startDate);
        int start_Date = cal.get(Calendar.HOUR_OF_DAY);

        cal.setTime(endDate);
        int end_Date = cal.get(Calendar.HOUR_OF_DAY);
        return end_Date - start_Date;
    }

    public static int calculateSaturday(Date startDate, Date endDate) {
        int day = calculateDayOfWeek(endDate);
        if (day == 6) {
            return calculateHoursForDay(startDate, endDate);
        } else {
            return 0;
        }
    }

    public static int calculateSunday(Date startDate, Date endDate) {
        int day = calculateDayOfWeek(endDate);
        if (day == 7) {
            return calculateHoursForDay(startDate, endDate);
        } else {
            return 0;
        }
    }

    public static int calculateSaturdayExtra(int hoursForWeek, Date endDate) {
        int day = calculateDayOfWeek(endDate);
        if (hoursForWeek > 48) {
            if (day == 6) {
                return calculateExtraHours(hoursForWeek, endDate);
            }
        }
        return 0;
    }

    public static int calculateSundayExtra(int hoursForWeek, Date endDate) {
        int day = calculateDayOfWeek(endDate);
        if (hoursForWeek > 48) {
            if (day == 7) {
                return calculateExtraHours(hoursForWeek, endDate);
            }
        }
        return 0;
    }

    public static int calculateSaturdayExtraNight(int totalHoras, Date endDate) {
        cal.setTime(endDate);
        int end_Date = cal.get(Calendar.HOUR_OF_DAY);
        int day = calculateDayOfWeek(endDate);
        if (end_Date > totalHoras) {
            if (day == 6) {
                return calculateNightHours(endDate);
            }
        }
        return 0;
    }

    public static int calculateSundayExtraNight(int hoursForWeek, Date endDate) {
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
