FROM maven:3.9.9-openjdk-17-slim AS build

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:17-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]