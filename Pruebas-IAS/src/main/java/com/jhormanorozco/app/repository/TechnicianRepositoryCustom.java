package com.jhormanorozco.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhormanorozco.app.dto.PostRequestDTO;
import com.jhormanorozco.app.dto.ResponseDTO;
import com.jhormanorozco.app.entity.Attention_Hour;

@Repository
public class TechnicianRepositoryCustom implements TechnicianRepository {

	private String QUERY_HORASXSEMANA = "SELECT TS.ID_TECNICO, S.NUMERO_SEMANA, SUM(HA.HORA_EXTRA) as HORA_EXTRA, SUM(HA.HORA_SABATINA) as HORA_SABATINA, SUM(HA.HORA_DOMINICAL) as HORA_DOMINICAL, SUM(HA.HORA_EXTRA_NOCTURNA) as HORA_EXTRA_NOCTURNA, SUM(HA.HORA_EXTRA_SABATINA) as HORA_EXTRA_SABATINA, SUM(HA.TOTAL_HORAS) as TOTAL_HORAS FROM HORA_ATENCION HA INNER JOIN DIA D ON HA.ID_HORA_ATENCION = D.ID_DIA INNER JOIN SEMANA S ON D.ID_DIA = S.ID_SEMANA INNER JOIN TECNICO_SERVICIO TS ON S.ID_SEMANA = TS.ID_SEMANA WHERE ID_TECNICO = :dni AND NUMERO_SEMANA = :n";

	@Autowired
	private EntityManager em;

	@Override
	public List<ResponseDTO> horasPorSemana(Long dni, Long n) throws Exception {
		try {
			Query query = em.createNativeQuery(QUERY_HORASXSEMANA, ResponseDTO.class);
			query.setParameter("dni", dni);
			query.setParameter("n", n);

			return query.getResultList();
		} catch (Exception e) {
			throw new Exception("Error al ejecutar la consulta", e);
		}
	}

	@Override
	public List<ResponseDTO> horasPorSemana1(Long dni, Long n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attention_Hour save(Attention_Hour post) {	
		em.persist(post);
		return post;
	}

}