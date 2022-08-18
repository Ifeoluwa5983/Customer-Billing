FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} worker.jar
ENTRYPOINT ["java","-jar","worker.jar"]