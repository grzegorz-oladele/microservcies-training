FROM maven:3.8.6-amazoncorretto-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-al2-jdk
WORKDIR /app
COPY --from=builder /app/target/rick-and-morty-0.0.1-SNAPSHOT.jar rick-and-morty-0.0.1-SNAPSHOT.jar
EXPOSE 8000
CMD ["java", "-jar", "rick-and-morty-0.0.1-SNAPSHOT.jar"]