package com.jhormanorozco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhormanorozco.app.entity.Service_Type;


public interface Service_TypeRepository extends JpaRepository<Service_Type, Long> {

}
