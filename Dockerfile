# Build stage
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /build

# Copy project files
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY src ./src

# Build the application
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Final stage
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Set JAVA_HOME (optional but explicit)
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH=$JAVA_HOME/bin:$PATH

# Copy JAR from builder stage
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]