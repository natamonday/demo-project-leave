FROM eclipse-temurin:21-jdk

WORKDIR /app

# Set JAVA_HOME (optional but explicit)
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH=$JAVA_HOME/bin:$PATH

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]