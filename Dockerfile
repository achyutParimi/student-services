# Use a base image with Java 17 and Alpine Linux
FROM alpine:3.18 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file and its dependencies to the container
COPY build/libs/student-services-1.0.jar app.jar

# Use the Spring Boot Maven plugin to repackage the JAR (optional)
#RUN java -Djarmode=layertools -jar app.jar extract

# Use a minimal base image for running the application
FROM alpine:3.18 AS runner

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR from the builder stage
COPY --from=builder /app/app.jar .

# Set the entry point for running the application
ENTRYPOINT ["java", "-jar", "app.jar"]