package com.example.monitoringapi.query;

import com.example.monitoringapi.metirc.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service public class QueryService {
    final private QueryExecutor queryExecutor;

    @Autowired
    public QueryService(QueryExecutor queryExecutor) {

        this.queryExecutor = queryExecutor;


    }

    public QueryResult query(Query query){

        List<Long> sensorIds;
        List<String> metrics;
        Map<Long, String> map = new HashMap<>();
        sensorIds = query.sensorIds;
        metrics = query.metrics;
        for(Long id: sensorIds){
            for(String metric: metrics){
                map.put(id, metric);
            }
        }

        List<Metric> resultList = queryExecutor.execute(query);

        Map<Map.Entry<Long,String>, List<Double>> tempResultMap = new HashMap<>();

        for (Metric m: resultList){
            Map.Entry<Long, String> entry = new AbstractMap.SimpleEntry<>(m.getSensorId(), m.getMetric());
            if (tempResultMap.get(entry) == null) {
                tempResultMap.put(entry, new ArrayList<>(Arrays.asList(m.getValue())));

            }
            else{
                tempResultMap.get(entry).add(m.getValue());
            }
        }
        Map<Map.Entry<Long,String>, Double> resultMap = new HashMap<>();
        for (Map.Entry<Map.Entry<Long, String>, List<Double>> entry: tempResultMap.entrySet()){
            List<Double> valueList = entry.getValue();
            double d = 0.0;
            for (Double value: valueList){
                d += value;
            }
            d = d/valueList.size();
            resultMap.put(entry.getKey(),d);
        }


        QueryResult queryResult = new QueryResult();
        queryResult.setResult(resultMap);
        return queryResult;
    }


}
