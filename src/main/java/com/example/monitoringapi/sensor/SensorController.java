package com.example.monitoringapi.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {


    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/{id}")
    public Sensor getSensor(@PathVariable Long id) {
        return sensorService.findSensorById(id).orElseThrow(
                ()-> new HttpClientErrorException(HttpStatus.NOT_FOUND)
        );

    }

    @PutMapping("{id}")
    public Sensor putSensor(@PathVariable Long id, @RequestBody @Valid Sensor sensor){
        Sensor confirmedSensor = sensorService.updateSensor(id, sensor);
        return confirmedSensor;

    }

    @PutMapping("/")
    public Sensor saveSensor(){
        Sensor s = new Sensor("s1", "dublin");
        sensorService.addSensor(s);
        return s;
    }


}