package com.jhormanorozco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhormanorozco.app.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

}
