FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn -f pom.xml clean package



FROM openjdk:11
EXPOSE 8084
COPY --from=build /target/csr-angular-1.0.0.SNAPSHOT.jar csr-angular.jar
ENTRYPOINT ["java","-jar","eureka-naming-server.jar"]