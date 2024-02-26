FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/tiary-3.0.0.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "/app.jar"]
