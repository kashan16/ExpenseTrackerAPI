# Use a base image with java 
FROM openjdk:17-jdk-alpine

# Set the working directory in container
WORKDIR /app

# Copy the JAR file into the container
COPY target/ExpenseAPI-0.0.1-SNAPSHOT.jar /app/ExpenseAPI.jar

# Expose the port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT [ "java" , "-jar" , "/app/ExpenseAPI.jar"]