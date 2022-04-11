package com.example.monitoringapi.sensor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SensorConfiguration {
    @Bean
    CommandLineRunner commandRunnable(SensorRepository sensorRepository){
        return args -> {
            Sensor s = new Sensor(1L, "s1", "dublin");
            sensorRepository.save(s);
        };
    }
}
