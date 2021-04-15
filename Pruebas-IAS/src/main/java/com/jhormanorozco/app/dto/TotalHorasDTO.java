package com.jhormanorozco.app.dto;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Immutable
public class TotalHorasDTO {

    @Column(name = "TOTAL_HORAS")
    private int TOTAL_HORAS;

    public int getTOTAL_HORAS() {
        return TOTAL_HORAS;
    }

    public void setTOTAL_HORAS(int TOTAL_HORAS) {
        this.TOTAL_HORAS = TOTAL_HORAS;
    }
}
