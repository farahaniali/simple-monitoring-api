# Simple Spring boot Monitoring API

## Requirements

For building and running the application you need:

- [JDK 17](https://openjdk.java.net/projects/jdk/17/)
- [Maven 3](https://maven.apache.org)
  - Before using Monitoring api you should compile and add this project. You can use this command: `mvn clean install`.


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.company.MonitoringAPIApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Sample Requests
* Add/Update new Sensor:
```shell
curl --location --request PUT 'http://localhost:8080/api/v1/sensors/14
' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"tempSensorC1",
"location":"Cork"
}'
```
* Report a Metric of a Sensor:
```shell

curl --location --request POST 'http://localhost:8080/api/v1/sensors/14/metrics/' \
--header 'Content-Type: application/json' \
--data-raw '{
"metric":"humid",
"value":10.0,
"timestamp":1234567872
}'
```
* Perform a Query on group of Sensors and group of Metrics:
```shell
curl --location --request POST 'http://localhost:8080/api/v1/queries/' \
--header 'Content-Type: application/json' \
--data-raw '{
  "sensorIds": [12,13],
  "metrics": ["temp","humid"],
  "fromDate":1234567800,
  "toDate":1234567900
}
'
```

# Engineering Decisions
There are multiple design decisions that are being made due to the pressure of time and clarity of the domain & problem space.
### Integrating Create and Update in one endpoint
As the user will indicate the ID of the sensor, therefore, the create and the update request could be handled by one endpoint making it more simple to implement and understand.

### Considering the reported Metric on a Sensor as a single Value
We consider reported value for any metric as a single entity that needs to be consumed by the system and then being stored.

### Not validating all the Sensor IDs in queries beforehand
There is not need to validate the Sensor IDs beforehand as it is possible for the user to get the sensor Data by another endpoint 

