package com.jhormanorozco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhormanorozco.app.entity.Technician_Service;

@Repository
public interface Technician_ServiceRepository extends JpaRepository<Technician_Service, Long> {

}
