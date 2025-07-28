# Start from OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the image
COPY target/OnlineBankingPortal-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (change if not 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
