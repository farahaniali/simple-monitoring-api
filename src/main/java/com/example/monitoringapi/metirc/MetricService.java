package com.example.monitoringapi.metirc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricService {
    final private MetricRepository reportRepository;

    @Autowired
    public MetricService(MetricRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    public Metric saveReport(Metric metric) {
//        metric.setTimestamp(java.sql.Timestamp.from(Instant.now()));
        Metric confirmedMetric = reportRepository.save(metric);
        return confirmedMetric;
    }


}
