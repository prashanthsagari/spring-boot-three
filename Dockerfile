FROM openjdk:17-jdk-slim-buster
#FROM openjdk:8-jdk-alpine
COPY target/spring-boot-three-1.0.jar spring-1.0.jar
ENTRYPOINT ["java","-jar","/spring-1.0.jar"]