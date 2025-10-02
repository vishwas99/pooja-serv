# Stage 1: Build the application with Maven
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:25-jdk-slim
WORKDIR /app

# Copy the built jar
COPY --from=build /app/target/*.jar app.jar

# Copy your CA cert into container
COPY src/main/resources/certs/ca.pem /app/certs/ca.pem

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]