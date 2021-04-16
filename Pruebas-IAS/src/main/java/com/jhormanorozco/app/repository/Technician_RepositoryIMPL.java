package com.jhormanorozco.app.repository;

import java.util.Collections;
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

    private final String QUERY_TOTAL_HORAS =
            "SELECT SUM(HA.TOTAL_HORAS) \n" +
                    "FROM \n" +
                    "HORA_ATENCION HA \n" +
                    "INNER JOIN DIA D ON HA.ID_HORA_ATENCION = D.ID_DIA \n" +
                    "INNER JOIN SEMANA S ON D.ID_DIA = S.ID_SEMANA \n" +
                    "INNER JOIN TECNICO_SERVICIO TS ON S.ID_SEMANA = TS.ID_SEMANA \n" +
                    "WHERE ID_TECNICO = :dni AND NUMERO_SEMANA = :n";

    private final String QUERY_POST = "BEGIN; INSERT INTO SERVICIO (ID_TIPO_SERVICIO) VALUES (:ID_TIPO_SERVICIO); INSERT INTO SEMANA (NUMERO_SEMANA) VALUES (:NUMERO_SEMANA); INSERT INTO DIA (DIA_SEMANA) VALUES ( :DIA_SEMANA); INSERT INTO HORA_ATENCION (HORA_INICIO, HORA_FIN, HORA_NOCTURNA, HORA_SABATINA, HORA_DOMINICAL, HORA_EXTRA, HORA_EXTRA_NOCTURNA, HORA_EXTRA_SABATINA, HORA_EXTRA_DOMINICAL, TOTAL_HORAS)  VALUES ( :HORA_INICIO, :HORA_FIN, :HORA_NOCTURNA, :HORA_SABATINA, :HORA_DOMINICAL, :HORA_EXTRA, :HORA_EXTRA_NOCTURNA, :HORA_EXTRA_SABATINA, :HORA_EXTRA_DOMINICAL, :TOTAL_HORAS); INSERT INTO TECNICO_SERVICIO (ID_TECNICO, ID_SERVICIO, ID_SEMANA) VALUES ( :ID_TECNICO, (SELECT MAX(ID_SERVICIO)  FROM SERVICIO), (SELECT MAX(ID_SEMANA)  FROM SEMANA) ); COMMIT;";

//    private final String QUERY_POST =
//                    "BEGIN;\n" +
//                    "INSERT INTO SERVICIO (ID_TIPO_SERVICIO) VALUES\n" +
//                    "(1);\n" +
//                    "INSERT INTO SEMANA (NUMERO_SEMANA) VALUES \n" +
//                    "(38);\n" +
//                    "INSERT INTO DIA (DIA_SEMANA) VALUES\n" +
//                    "(4);\n" +
//                    "INSERT INTO HORA_ATENCION  \n" +
//                    "(HORA_INICIO, HORA_FIN, HORA_NOCTURNA, HORA_SABATINA,HORA_DOMINICAL, HORA_EXTRA, HORA_EXTRA_NOCTURNA, HORA_EXTRA_SABATINA, HORA_EXTRA_DOMINICAL, TOTAL_HORAS)\n" +
//                    " VALUES\n" +
//                    "('2020/09/13 11:00:00','2020/09/13 18:00:00',0,1,1,5,0,0,0,7);\n" +
//                    "INSERT INTO TECNICO_SERVICIO (ID_TECNICO, ID_SERVICIO, ID_SEMANA) VALUES\n" +
//                    "(1223212,\n" +
//                    "(SELECT MAX(ID_SERVICIO)  FROM SERVICIO),\n" +
//                    "(SELECT MAX(ID_SEMANA)  FROM SEMANA)\n" +
//                    ");\n" +
//                    "COMMIT;";

    private final String QUERY_POST_SERVICIO = "BEGIN; INSERT INTO SERVICIO (ID_TIPO_SERVICIO) VALUES (:ID_TIPO_SERVICIO);";

    private final String QUERY_POST_SEMANA = "INSERT INTO SEMANA (NUMERO_SEMANA) VALUES (:NUMERO_SEMANA);";

    private final String QUERY_POST_DIA = "INSERT INTO DIA (DIA_SEMANA) VALUES ( :DIA_SEMANA);";

    private final String QUERY_POST_HORA_ATENCION = "INSERT INTO HORA_ATENCION (HORA_INICIO, HORA_FIN, HORA_NOCTURNA, HORA_SABATINA, HORA_DOMINICAL, HORA_EXTRA, HORA_EXTRA_NOCTURNA, HORA_EXTRA_SABATINA, HORA_EXTRA_DOMINICAL, TOTAL_HORAS)  VALUES ( :HORA_INICIO, :HORA_FIN, :HORA_NOCTURNA, :HORA_SABATINA, :HORA_DOMINICAL, :HORA_EXTRA, :HORA_EXTRA_NOCTURNA, :HORA_EXTRA_SABATINA, :HORA_EXTRA_DOMINICAL, :TOTAL_HORAS);";

    private final String QUERY_POST_TECNICO_SERVICIO = "INSERT INTO TECNICO_SERVI1CIO (ID_TECNICO, ID_SERVICIO, ID_SEMANA) VALUES ( :ID_TECNICO, (SELECT MAX(ID_SERVICIO)  FROM SERVICIO), (SELECT MAX(ID_SEMANA)  FROM SEMANA) ) COMMIT;";

    @Autowired
    private EntityManager em;

    public void postServicio(PostDataDTO post) throws Exception {
        try {
            Query query = em.createNativeQuery(QUERY_POST_SERVICIO);
            query.setParameter("ID_TIPO_SERVICIO", post.getID_TIPO_SERVICIO());
        } catch (Exception e) {
            throw new Exception("Error en el método postServicio: " + e);
        }
    }

    public void postSemana(PostDataDTO post) throws Exception {
        try {
            Query query = em.createNativeQuery(QUERY_POST_SEMANA);
            query.setParameter("NUMERO_SEMANA", post.getNUMERO_SEMANA());
        } catch (Exception e) {
            throw new Exception("Error en el método postSemana: " + e);
        }
    }

    public void postDia(PostDataDTO post) throws Exception {
        try {
            Query query = em.createNativeQuery(QUERY_POST_DIA);
            query.setParameter("DIA_SEMANA", post.getDIA_SEMANA());
        } catch (Exception e) {
            throw new Exception("Error en el método postDia: " + e);
        }
    }

    public void postHoraAtencion(PostDataDTO post) throws Exception {
        try {
            Query query = em.createNativeQuery(QUERY_POST_HORA_ATENCION);
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
        } catch (Exception e) {
            throw new Exception("Error en el método postHoraAtencion: " + e);
        }
    }

    public void postTecnicoServicio(PostDataDTO post) throws Exception {
        try {
            Query query = em.createNativeQuery(QUERY_POST_TECNICO_SERVICIO);
            query.setParameter("ID_TECNICO", post.getDIA_SEMANA());
        } catch (Exception e) {
            throw new Exception("Error en el método postDia: " + e);
        }
    }

    public List getTotalHoras(int dni, int n) throws Exception {
        try {
            Query query = em.createNativeQuery(QUERY_TOTAL_HORAS);
            query.setParameter("dni", dni);
            query.setParameter("n", n);

            return Collections.singletonList(query.getFirstResult());
        } catch (Exception e) {
            throw new Exception("Error consultando horas en metodo getTotalHoras(repository): " + e);
        }
    }

    @Override
    public List save(PostDataDTO post) throws Exception {
        try {
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

            System.out.println(query);

            return horasPorSemana(post.getID_TECNICO(), post.getNUMERO_SEMANA());
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la inserción: " + e);
        }
    }

//    @Override
//    public List save(PostDataDTO post) throws Exception {
//        try {
//            postServicio(post);
//            postSemana(post);
//            postDia(post);
//            postHoraAtencion(post);
//            postTecnicoServicio(post);
//
//            return horasPorSemana(post.getID_TECNICO(),post.getNUMERO_SEMANA());
//        } catch (Exception e) {
//            throw new Exception("Error al ejecutar la inserción en repositoryIMPL: " + e);
//        }
//    }

    @Override
    public List horasPorSemana(int dni, int n) throws Exception {
        try {
            Query query = em.createNativeQuery(QUERY_HORASXSEMANA, ResponseDTO.class);
            query.setParameter("dni", dni);
            query.setParameter("n", n);

            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la consulta horasPorSemana repository: " + e);
        }
    }

}