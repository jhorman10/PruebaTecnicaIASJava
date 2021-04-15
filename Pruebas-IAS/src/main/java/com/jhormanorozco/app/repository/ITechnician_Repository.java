package com.jhormanorozco.app.repository;

import java.util.List;

import com.jhormanorozco.app.dto.PostDataDTO;


public interface ITechnician_Repository {

    List horasPorSemana(int dni, int n) throws Exception;

    List save(PostDataDTO post) throws Exception;
}

