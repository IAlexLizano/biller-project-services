FROM amazoncorretto:17-alphine-jdk

COPY target\biller-project-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]