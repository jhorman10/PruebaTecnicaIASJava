package com.calculadorahoras.app.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.calculadorahoras.app.dto.PostDataDTO;
import com.calculadorahoras.app.dto.ResponseDTO;

@Repository
public class Technician_RepositoryIMPL implements ITechnician_Repository {

    @Autowired
    private EntityManager em;

    @Override
    public List save(PostDataDTO post) throws Exception {
        try {
            String QUERY_POST =
                    "BEGIN;\n" +
                    "INSERT INTO SERVICIO (ID_TIPO_SERVICIO) VALUES\n" +
                    "(:ID_TIPO_SERVICIO);\n" +
                    "INSERT INTO SEMANA (NUMERO_SEMANA) VALUES \n" +
                    "(:NUMERO_SEMANA);\n" +
                    "INSERT INTO DIA (DIA_SEMANA) VALUES\n" +
                    "(:DIA_SEMANA);\n" +
                    "INSERT INTO HORA_ATENCION  \n" +
                    "(HORA_INICIO, HORA_FIN, HORA_NOCTURNA,\n" +
                    "HORA_SABATINA, HORA_DOMINICAL, HORA_EXTRA,\n" +
                    "HORA_EXTRA_NOCTURNA, HORA_EXTRA_SABATINA, \n" +
                    "HORA_EXTRA_DOMINICAL, TOTAL_HORAS)\n" +
                    " VALUES\n" +
                    "(:HORA_INICIO,\n" +
                    ":HORA_FIN,\n" +
                    ":HORA_NOCTURNA,\n" +
                    ":HORA_SABATINA,\n" +
                    ":HORA_DOMINICAL,\n" +
                    ":HORA_EXTRA,\n" +
                    ":HORA_EXTRA_NOCTURNA,\n" +
                    ":HORA_EXTRA_SABATINA,\n" +
                    ":HORA_EXTRA_DOMINICAL,\n" +
                    ":TOTAL_HORAS);\n" +
                    "INSERT INTO TECNICO_SERVICIO (ID_TECNICO, ID_SERVICIO, ID_SEMANA) VALUES\n" +
                    "(:ID_TECNICO,\n" +
                    "(SELECT MAX(ID_SERVICIO)  FROM SERVICIO),\n" +
                    "(SELECT MAX(ID_SEMANA)  FROM SEMANA));\n" +
                    "COMMIT;";
            Query query = em.createNativeQuery(QUERY_POST, PostDataDTO.class);
            query.setParameter("HORA_INICIO", post.getHORA_INICIO());
            query.setParameter("HORA_FIN", post.getHORA_FIN());
            query.setParameter("DIA_SEMANA", post.getDIA_SEMANA());
            query.setParameter("HORA_NOCTURNA", post.getHORA_NOCTURNA());
            query.setParameter("HORA_SABATINA", post.getHORA_SABATINA());
            query.setParameter("HORA_DOMINICAL", post.getHORA_DOMINICAL());
            query.setParameter("HORA_EXTRA", post.getHORA_EXTRA());
            query.setParameter("HORA_EXTRA_NOCTURNA", post.getHORA_EXTRA_NOCTURNA());
            query.setParameter("HORA_EXTRA_SABATINA", post.getHORA_EXTRA_SABATINA());
            query.setParameter("HORA_EXTRA_DOMINICAL", post.getHORA_EXTRA_DOMINICAL());
            query.setParameter("TOTAL_HORAS", post.getTOTAL_HORAS());
            query.setParameter("ID_TECNICO", post.getID_TECNICO());
            query.setParameter("NUMERO_SEMANA", post.getNUMERO_SEMANA());
            query.setParameter("ID_TIPO_SERVICIO", post.getID_TIPO_SERVICIO());

            return getTotalHoras(post.getID_TECNICO(), post.getNUMERO_SEMANA());
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la inserción: " + e);
        }
    }

    @Override
    public List horasPorSemana(int dni, int n) throws Exception {
        try {
            String QUERY_HORASXSEMANA =
                    "SELECT\n" +
                    "TS.ID_TECNICO,S.NUMERO_SEMANA,\n" +
                    "SUM(HA.HORA_NOCTURNA) as HORA_NOCTURNA,\n" +
                    "SUM(HA.HORA_SABATINA) as HORA_SABATINA,\n" +
                    "SUM(HA.HORA_DOMINICAL) as HORA_DOMINICAL,\n" +
                    "SUM(HA.HORA_EXTRA) as HORA_EXTRA,\n" +
                    "SUM(HA.HORA_EXTRA_NOCTURNA) as HORA_EXTRA_NOCTURNA,\n" +
                    "SUM(HA.HORA_EXTRA_DOMINICAL) as HORA_EXTRA_DOMINICAL,\n" +
                    "SUM(HA.HORA_EXTRA_SABATINA) as HORA_EXTRA_SABATINA,\n" +
                    "SUM(HA.TOTAL_HORAS) as TOTAL_HORAS\n" +
                    "FROM \n" +
                    "HORA_ATENCION HA \n" +
                    "INNER JOIN DIA D ON HA.ID_HORA_ATENCION = D.ID_DIA\n" +
                    "INNER JOIN SEMANA S ON D.ID_DIA = S.ID_SEMANA\n" +
                    "INNER JOIN TECNICO_SERVICIO TS ON S.ID_SEMANA = TS.ID_SEMANA\n" +
                    "WHERE ID_TECNICO = :dni AND NUMERO_SEMANA = :n";

            Query query = em.createNativeQuery(QUERY_HORASXSEMANA, ResponseDTO.class);
            query.setParameter("dni", dni);
            query.setParameter("n", n);

            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la consulta horasPorSemana repository: " + e);
        }
    }

    public List getTotalHoras(int dni, int n) throws Exception {
        try {
            String QUERY_TOTAL_HORAS =
                    "SELECT SUM(HA.TOTAL_HORAS) AS TOTAL_HORAS\n" +
                    "FROM \n" +
                    "HORA_ATENCION HA \n" +
                    "LEFT JOIN DIA D ON HA.ID_HORA_ATENCION = D.ID_DIA\n" +
                    "LEFT JOIN SEMANA S ON D.ID_DIA = S.ID_SEMANA\n" +
                    "LEFT JOIN TECNICO_SERVICIO TS ON S.ID_SEMANA = TS.ID_SEMANA\n" +
                    "WHERE ID_TECNICO = :dni AND NUMERO_SEMANA = :n";

            Query query = em.createNativeQuery(QUERY_TOTAL_HORAS);
            query.setParameter("dni", dni);
            query.setParameter("n", n);

            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error consultando horas en metodo getTotalHoras(repository): " + e);
        }
    }
}