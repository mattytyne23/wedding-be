# Use OpenJDK 17 with Maven already installed
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set work directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source
COPY src src

# Build the JAR
RUN mvn clean package -DskipTests

# ---- Runtime image ----
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the JAR
CMD ["java","-jar","app.jar"]
