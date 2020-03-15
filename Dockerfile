FROM openjdk:11.0.6-jre-slim
COPY target/enter-events-service-0.0.1-SNAPSHOT.jar .
CMD  ["java", "-jar" , "enter-events-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
