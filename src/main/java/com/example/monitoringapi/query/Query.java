package com.example.monitoringapi.query;

import java.util.Date;
import java.util.List;

public class Query {
    Date fromDate;
    Date toDate;

    List<Long> sensorIds;
    List<String> metrics;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<Long> getSensorIds() {
        return sensorIds;
    }

    public void setSensorIds(List<Long> sensorIds) {
        this.sensorIds = sensorIds;
    }

    public List<String> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<String> metrics) {
        this.metrics = metrics;
    }



}
