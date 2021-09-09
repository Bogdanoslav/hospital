# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13

# copy the packaged jar file into our docker image
COPY target/appointments-0.0.1.jar /appointments.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/appointments.jar"]