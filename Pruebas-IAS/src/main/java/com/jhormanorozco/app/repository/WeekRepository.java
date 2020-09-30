package com.jhormanorozco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhormanorozco.app.entity.Week;

@Repository
public interface WeekRepository extends JpaRepository<Week, Long>{

}
