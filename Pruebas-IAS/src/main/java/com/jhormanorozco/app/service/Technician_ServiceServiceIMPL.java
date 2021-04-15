package com.jhormanorozco.app.service;

import java.util.Collections;
import java.util.List;
import com.jhormanorozco.app.dto.PostDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhormanorozco.app.repository.Technician_RepositoryIMPL;

@Service
public class Technician_ServiceServiceIMPL implements ITechnician_ServiceService {

    @Autowired
    private Technician_RepositoryIMPL technicianRepository;

    @Override
    public List obtenerHoras(int dni, int week) throws Exception {
        return technicianRepository.horasPorSemana(dni, week);
    }

    @Override
    public List save(PostDataDTO post) throws Exception {
        return technicianRepository.save(post);
    }
}
