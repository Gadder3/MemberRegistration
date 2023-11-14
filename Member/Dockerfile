FROM openjdk:17-jre-hotspot


# Copy your Spring Boot JAR file from the build context into the container
COPY target/Member-0.0.1-SNAPSHOT.jar /app/app.jar

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
