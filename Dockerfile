FROM maven:3.8.5-openjdk-17 AS DEPENDENCIES
WORKDIR /opt/app
COPY pom.xml .

FROM maven:3.8.5-openjdk-17 AS BUILDER
WORKDIR /opt/app
COPY --from=DEPENDENCIES /root/.m2 /root/.m2
COPY --from=DEPENDENCIES /opt/app/ /opt/app
COPY src /opt/app/src
RUN mvn clean install -DskipTests

FROM openjdk:17-slim
WORKDIR /opt/app
COPY --from=BUILDER /opt/app/api/target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]