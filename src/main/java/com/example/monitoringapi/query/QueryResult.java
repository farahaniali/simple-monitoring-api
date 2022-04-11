package com.example.monitoringapi.query;

import java.util.Map;

public class QueryResult {


    Map<Map.Entry<Long,String>, Double> result;


    public Map<Map.Entry<Long, String>, Double> getResult() {
        return result;
    }

    public void setResult(Map<Map.Entry<Long, String>, Double> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "result=" + result +
                '}';
    }

    //    Map<Long,Long> result;
//
//    public Map<Long, Long> getResult() {
//        return result;
//    }
//
//    public void setResult(Map<Long, Long> result) {
//        this.result = result;
//    }
}
