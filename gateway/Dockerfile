FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/gateway-3.0.0.jar
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "/app.jar"]
