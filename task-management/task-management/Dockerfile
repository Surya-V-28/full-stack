# Use the official Maven image to build the project
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn clean package

# Use the official OpenJDK image to run the project
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/task-management-0.0.1-SNAPSHOT.jar /app/task-management.jar
ENTRYPOINT ["java", "-jar", "/app/task-management.jar"]
