# Stage 1: Build the application with Maven
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR 
COPY . .
RUN mvn -B -DskipTests clean package

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
