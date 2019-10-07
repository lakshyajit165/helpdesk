FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
CMD mvn:go-offline
COPY src src
RUN mvn -f pom.xml clean package -DskipTests


FROM openjdk:11
EXPOSE 8080
COPY --from=build /target/command-framework-1.0.0.SNAPSHOT.jar command-framework.jar
ENTRYPOINT ["java","-jar","command-framework.jar"]
