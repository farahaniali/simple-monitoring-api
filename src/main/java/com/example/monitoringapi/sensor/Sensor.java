package com.example.monitoringapi.sensor;


import javax.persistence.*;

@Entity
@Table
public class Sensor {

    @Id
    private Long id;

    private String name;

    private String location;

    public Sensor(Long id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;

    }
    public Sensor( String name, String location){

        this.name = name;
        this.location = location;

    }

    public Sensor() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}