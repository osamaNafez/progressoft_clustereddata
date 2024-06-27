FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/progressoft-clustereddata-0.0.1-SNAPSHOT.jar /app/progressoft-clustereddata.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/progressoft-clustereddata.jar"]
