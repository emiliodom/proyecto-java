# Stage 1: Build the application with Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only the pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the source code and build the JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the lightweight runtime image
# Using Eclipse Temurin instead of the deprecated openjdk images
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Render provides the port via the PORT environment variable.
# This command tells Java to listen on that port.
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT} -jar app.jar"]