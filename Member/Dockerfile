FROM openjdk:11-jre-slim

# Create a directory to store your application
RUN mkdir /app

# Set the working directory to the newly created directory
WORKDIR /app

# Copy your Spring Boot JAR file from the build context into the container
COPY target/Member-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]


