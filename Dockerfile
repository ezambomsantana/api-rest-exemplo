FROM openjdk:11-jdk-slim

ARG JAR_FILE=target/spring-boot-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]