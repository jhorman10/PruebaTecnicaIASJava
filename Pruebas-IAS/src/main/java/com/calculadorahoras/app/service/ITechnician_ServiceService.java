package com.calculadorahoras.app.service;

import java.util.Date;
import java.util.List;

public interface ITechnician_ServiceService {

    List getTotalHoras(int dni, int week) throws Exception;

    List obtenerHoras(int dni, int week) throws Exception;

    List save(Date startDate, Date endDate, int dni, int n, int tHoras) throws Exception;

}
