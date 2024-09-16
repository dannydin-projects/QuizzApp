# Use the official OpenJDK 22 base image
FROM eclipse-temurin:22-jdk-alpine

# Create a volume for temporary files
VOLUME /tmp

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose port 8080
EXPOSE 8080
