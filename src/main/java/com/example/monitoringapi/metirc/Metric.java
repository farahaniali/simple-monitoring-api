package com.example.monitoringapi.metirc;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Metric {
    @Id
    @SequenceGenerator(name = "metric_id_gen", sequenceName = "metric_id_gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metric_id_gen")
    @Column(name = "id", nullable = false)
    private Long id;
    private Long sensorId;
    private String metric;
    private double value;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Metric(Long id, Long sensorId, String metric, double value, Date timestamp) {
        this.id = id;
        this.sensorId = sensorId;
        this.metric = metric;
        this.value = value;
        this.timestamp = timestamp;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
