package com.example.monitoringapi.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public void addSensor(Sensor s){
        sensorRepository.save(s);

    }

    public Sensor updateSensor(Long id, Sensor sensor) {
        if (sensorRepository.existsById(id)){
            sensor.setId(id);
            sensorRepository.save(sensor);

        }
        else{
            sensor.setId(id);
            sensorRepository.save(sensor);
        }
        return sensor;
    }

    public Optional<Sensor> findSensorById(Long id){
        return sensorRepository.findById(id);
    }
}
