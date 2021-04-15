package com.jhormanorozco.app.service;

import java.util.List;

import com.jhormanorozco.app.dto.PostDataDTO;

public interface ITechnician_ServiceService {

    public List obtenerHoras(int dni, int week) throws Exception;

    public List save(PostDataDTO post) throws Exception;

}
