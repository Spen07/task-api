FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -q

COPY src/ src/
ARG NEXUS_URL
RUN ./mvnw package -DskipTests -Dnexus.url=${NEXUS_URL} -s ci-settings.xml

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=builder /app/target/task-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]
