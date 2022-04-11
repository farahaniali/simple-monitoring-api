package com.example.monitoringapi.metirc;

import com.example.monitoringapi.sensor.Sensor;
import com.example.monitoringapi.sensor.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/v1/sensors/{id}/metrics")
public class MetricController {

    private final MetricService reportService;
    private final SensorService sensorService;


    @Autowired
    public MetricController(MetricService reportService, SensorService sensorService) {
        this.reportService = reportService;
        this.sensorService = sensorService;
    }

    @PostMapping("/")
    public String postMetric(@PathVariable("id") Long sensorId,@Validated @RequestBody Metric report){
        Sensor sensor = sensorService.findSensorById(sensorId)
                .orElseThrow(()->
                        new HttpClientErrorException(HttpStatus.NOT_FOUND,"No Such Sensor is Registered in the System!")
                );

        report.setId(sensorId);
        Metric confirmed_report = reportService.saveReport(report);
        return confirmed_report.getId().toString();
    }

}
