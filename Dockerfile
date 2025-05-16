FROM maven:3.8.5-openjdk-17 AS BUILDER
WORKDIR /opt/app
COPY pom.xml .
COPY src ./src
RUN mvn -f ./pom.xml clean package

FROM openjdk:17-slim
WORKDIR /opt/app
COPY --from=BUILDER target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]