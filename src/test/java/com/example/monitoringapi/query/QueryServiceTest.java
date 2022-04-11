package com.example.monitoringapi.query;


import com.example.monitoringapi.metirc.Metric;
import com.example.monitoringapi.query.Query;
import com.example.monitoringapi.query.QueryExecutor;
import com.example.monitoringapi.query.QueryResult;
import com.example.monitoringapi.query.QueryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class QueryServiceTest {
    @Test
    public void test() {

        QueryExecutor mock = Mockito.mock(QueryExecutor.class);
        Mockito.when(mock.execute(any())).thenReturn(sample());
        QueryService cut = new QueryService(mock);

        Query query = new Query();
        query.setSensorIds(Arrays.asList(12L));
        query.setFromDate(new Date());
        query.setToDate(new Date());
        query.setMetrics(Arrays.asList("temp"));

        QueryResult result = cut.query(query);
        assertEquals("QueryResult{result={12=temp=60.0}}", result.toString() );
        System.out.println(result);

    }

    private List<Metric> sample() {
        return Arrays.asList(
                metric(12L,12L, "temp", 120, 12346890L),
                metric(12L,12L, "temp", 120, 12346890L),
                metric(12L,12L, "temp", 0, 12346890L),
                metric(12L,12L, "temp", 0, 12346890L));
    }

    private Metric metric(long id, long sensorId, String metric, float value, long timestamp) {
        return new Metric(id,sensorId, metric, value, new Date(timestamp));
    }

}