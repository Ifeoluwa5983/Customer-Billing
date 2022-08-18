FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} billing.jar
ENTRYPOINT ["java","-jar","billing.jar"]