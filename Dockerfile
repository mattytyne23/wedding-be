# Use an official Java runtime
FROM eclipse-temurin:17-jdk

# Create app directory
WORKDIR /app

# Copy Maven wrapper and pom first to leverage caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Build application
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src src

# Build the JAR
RUN ./mvnw clean package -DskipTests

# Run the JAR
CMD ["java", "-jar", "target/wedding-rsvp-backend-0.0.1-SNAPSHOT.jar"]
