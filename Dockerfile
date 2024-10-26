# Use a base image with Java 8 or higher (based on your Spring Boot app's Java version)
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/SpringCrud-0.0.1-SNAPSHOT.jar /app/application.jar

# Expose the port on which the Spring Boot app will run (default 8080)
EXPOSE 9004

# Command to run the JAR file
ENTRYPOINT ["java","-jar","/app/application.jar"]
