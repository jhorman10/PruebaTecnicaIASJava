package com.jhormanorozco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhormanorozco.app.entity.Attention_Hour;

@Repository
public interface Attention_HourRepository extends JpaRepository<Attention_Hour, Long> {

}
