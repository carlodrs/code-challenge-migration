FROM maven:3.8.5-openjdk-17
EXPOSE 8080
RUN mvn clean install
ARG JAR_FILE=target/dummyjson.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]