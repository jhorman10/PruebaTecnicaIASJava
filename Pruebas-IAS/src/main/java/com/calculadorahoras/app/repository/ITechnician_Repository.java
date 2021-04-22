package com.calculadorahoras.app.repository;

import java.util.List;

import com.calculadorahoras.app.dto.PostDataDTO;


public interface ITechnician_Repository {
    List getTotalHoras(int dni, int n) throws Exception;

    List horasPorSemana(int dni, int n) throws Exception;

    List save(PostDataDTO post) throws Exception;

}

