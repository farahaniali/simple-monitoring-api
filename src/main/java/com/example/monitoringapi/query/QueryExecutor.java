package com.example.monitoringapi.query;

import com.example.monitoringapi.metirc.Metric;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.util.List;

@Component
public class QueryExecutor {
    @PersistenceContext
    EntityManager em;




    public List<Metric> execute(Query query){
        String jpql = "select m from Metric m where m.timestamp >= :from and m.timestamp <= :to " +
                "and m.sensorId in (:sensorIds) and m.metric in (:metrics)";

        javax.persistence.Query jpqlQuery = em.createQuery(jpql, Metric.class);
        jpqlQuery.setParameter("from", query.fromDate, TemporalType.TIMESTAMP);
        jpqlQuery.setParameter("to", query.toDate, TemporalType.TIMESTAMP);
        jpqlQuery.setParameter("sensorIds", query.sensorIds);
        jpqlQuery.setParameter("metrics", query.metrics);

        return jpqlQuery.getResultList();

    }

}
