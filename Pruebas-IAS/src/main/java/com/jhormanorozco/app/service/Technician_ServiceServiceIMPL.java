package com.jhormanorozco.app.service;

import java.util.List;
import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.repository.ITechnician_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhormanorozco.app.repository.Technician_RepositoryIMPL;

@Service
public class Technician_ServiceServiceIMPL implements ITechnician_ServiceService {

    @Autowired
    private ITechnician_Repository technicianRepository;

    @Override
    public List obtenerHoras(int dni, int week) throws Exception {
        return technicianRepository.horasPorSemana(dni, week);
    }

    @Override
    public List save(PostDataDTO post) throws Exception {
        return technicianRepository.save(post);
    }
}
