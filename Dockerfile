# Use a base image with Java installed (e.g., OpenJDK 17)
FROM openjdk:25-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from your build context to the container
COPY target/PoojaServices-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Define the command to run your application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]