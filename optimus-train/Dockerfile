FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn -f pom.xml clean package

FROM openjdk:11
EXPOSE 8761
COPY --from=build /target/optimus-train-1.0.0-SNAPSHOT.jar optimus-train.jar
ENTRYPOINT ["java","-jar","optimus-train.jar"]

