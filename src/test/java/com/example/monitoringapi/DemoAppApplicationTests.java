package com.example.monitoringapi;

import com.example.monitoringapi.metirc.MetricController;
import com.example.monitoringapi.query.QueryController;
import com.example.monitoringapi.sensor.SensorController;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoAppApplicationTests {

    @Autowired
    private SensorController sensorController;

    @Autowired
    private QueryController queryController;

    @Autowired
    private MetricController metricController;


    @Test
    void contextLoads() {

        Assertions.assertThat(sensorController).isNotNull();
        Assertions.assertThat(metricController).isNotNull();
        Assertions.assertThat(queryController).isNotNull();

    }

}
