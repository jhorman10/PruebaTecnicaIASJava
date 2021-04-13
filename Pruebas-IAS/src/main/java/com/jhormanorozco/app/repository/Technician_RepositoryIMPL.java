package com.jhormanorozco.app.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jhormanorozco.app.dto.PostDataDTO;
import com.jhormanorozco.app.dto.ResponseDTO;

@Repository
public class Technician_RepositoryIMPL implements ITechnician_Repository {

	private final String QUERY_HORASXSEMANA = "SELECT TS.ID_TECNICO, S.NUMERO_SEMANA, SUM(HA.HORA_EXTRA) as HORA_EXTRA, SUM(HA.HORA_SABATINA) as HORA_SABATINA, SUM(HA.HORA_DOMINICAL) as HORA_DOMINICAL, SUM(HA.HORA_EXTRA_NOCTURNA) as HORA_EXTRA_NOCTURNA, SUM(HA.HORA_EXTRA_SABATINA) as HORA_EXTRA_SABATINA, SUM(HA.TOTAL_HORAS) as TOTAL_HORAS FROM HORA_ATENCION HA INNER JOIN DIA D ON HA.ID_HORA_ATENCION = D.ID_DIA INNER JOIN SEMANA S ON D.ID_DIA = S.ID_SEMANA INNER JOIN TECNICO_SERVICIO TS ON S.ID_SEMANA = TS.ID_SEMANA WHERE ID_TECNICO = :dni AND NUMERO_SEMANA = :n";

	private final String QUERY_TOTAL_HORAS = "SELECT SUM(HA.TOTAL_HORAS) AS TOTAL_HORAS FROM HORA_ATENCION HA LEFT JOIN DIA D ON HA.ID_HORA_ATENCION = D.ID_DIA INNER JOIN SEMANA S ON D.ID_DIA = S.ID_SEMANA INNER JOIN TECNICO_SERVICIO TS ON S.ID_SEMANA = TS.ID_SEMANA WHERE ID_TECNICO = :dni AND NUMERO_SEMANA = :n";

	private final String QUERY_POST = "BEGIN; INSERT INTO SERVICIO (ID_TIPO_SERVICIO) VALUES (:ID_TIPO_SERVICIO); INSERT INTO SEMANA (NUMERO_SEMANA) VALUES  (:NUMERO_SEMANA); INSERT INTO DIA (DIA_SEMANA) VALUES (:DIA_SEMANA); INSERT INTO HORA_ATENCION   (HORA_INICIO, HORA_FIN,HORA_NOCTURNA,HORA_SABATINA,HORA_DOMINICAL,HORA_EXTRA,HORA_EXTRA_NOCTURNA,HORA_EXTRA_SABATINA,HORA_EXTRA_DOMINICAL,TOTAL_HORAS)  VALUES (:HORA_INICIO,:HORA_FIN,HORA_NOCTURNA,:HORA_SABATINA,:HORA_DOMINICAL,:HORA_EXTRA,:HORA_EXTRA_NOCTURNA,:HORA_EXTRA_SABATINA,:HORA_EXTRA_DOMINICAL,:TOTAL_HORAS); INSERT INTO TECNICO_SERVICIO (ID_TECNICO, ID_SERVICIO, ID_SEMANA) VALUES (:ID_TECNICO, (SELECT MAX(ID_SERVICIO)  FROM SERVICIO), (SELECT MAX(ID_SEMANA)  FROM SEMANA) ); COMMIT;";

	@Autowired
	private EntityManager em;

	@Override
	public List<ResponseDTO> save(int HORA_INICIO, int HORA_FIN, int HORA_NOCTURNA, int HORA_SABATINA, int HORA_DOMINICAL, int HORA_EXTRA, int HORA_EXTRA_NOCTURNA, int HORA_EXTRA_SABATINA, int HORA_EXTRA_DOMINICAL, int TOTAL_HORAS, int ID_TECNICO) throws Exception {
		try {
			Query query = em.createNativeQuery(QUERY_POST, PostDataDTO.class);
			query.setParameter("HORA_INICIO", HORA_INICIO);
			query.setParameter("HORA_FIN", HORA_FIN);
			query.setParameter("HORA_NOCTURNA", HORA_NOCTURNA);
			query.setParameter("HORA_SABATINA", HORA_SABATINA);
			query.setParameter("HORA_DOMINICAL", HORA_DOMINICAL);
			query.setParameter("HORA_EXTRA", HORA_EXTRA);
			query.setParameter("HORA_EXTRA_NOCTURNA", HORA_EXTRA_NOCTURNA);
			query.setParameter("HORA_EXTRA_SABATINA", HORA_EXTRA_SABATINA);
			query.setParameter("HORA_EXTRA_DOMINICAL", HORA_EXTRA_DOMINICAL);
			query.setParameter("TOTAL_HORAS", TOTAL_HORAS);
			query.setParameter("ID_TECNICO", ID_TECNICO);
			
			return (List<ResponseDTO>) query.getResultList();
		} catch (Exception e) {
			throw new Exception("Error al ejecutar la inserción: "+ e);
		}
	}

	@Override
	public List<ResponseDTO> save(PostDataDTO post) throws Exception {
		try {
			Query query = em.createNativeQuery(QUERY_POST, PostDataDTO.class);
			query.setParameter("HORA_INICIO", post.getHORA_INICIO());
			query.setParameter("HORA_FIN", post.getHORA_FIN());
			query.setParameter("HORA_NOCTURNA", post.getHORA_NOCTURNA());
			query.setParameter("HORA_SABATINA", post.getHORA_SABATINA());
			query.setParameter("HORA_DOMINICAL", post.getHORA_DOMINICAL());
			query.setParameter("HORA_EXTRA", post.getHORA_EXTRA());
			query.setParameter("HORA_EXTRA_NOCTURNA", post.getHORA_EXTRA_NOCTURNA());
			query.setParameter("HORA_EXTRA_SABATINA", post.getHORA_EXTRA_SABATINA());
			query.setParameter("HORA_EXTRA_DOMINICAL", post.getHORA_EXTRA_DOMINICAL());
			query.setParameter("TOTAL_HORAS", post.getTOTAL_HORAS());
			query.setParameter("ID_TECNICO", post.getID_TECNICO());

			return (List<ResponseDTO>) query.getResultList();
		} catch (Exception e) {
			throw new Exception("Error al ejecutar la inserción: "+ e);
		}
	}

	@Override
	public List horasPorSemana(Long dni, Long n) throws Exception {
		try {
			Query query = em.createNativeQuery(QUERY_HORASXSEMANA, ResponseDTO.class);
			query.setParameter("dni", dni);
			query.setParameter("n", n);

			return query.getResultList();
		} catch (Exception e) {
			throw new Exception("Error al ejecutar la consulta: "+ e);
		}
	}

	@Override
	public int totalHoras(Long dni, Long n) throws Exception {
		try{
			//return horasPorSemana(dni, n);
			Query query = em.createQuery(QUERY_TOTAL_HORAS, ResponseDTO.class);
			query.setParameter("dni", dni);
			query.setParameter("n", n);

			return query.getFirstResult();
		}catch (Exception e){
			throw new Exception("No se pudo calcular el total de horas: " + e);
		}
	}
}