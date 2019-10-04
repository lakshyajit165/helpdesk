FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn -f pom.xml clean package



FROM openjdk:11
EXPOSE 8182
COPY --from=build /target/csr-service-1.0.0.SNAPSHOT.jar csr-service.jar
ENTRYPOINT ["java","-jar","csr-service.jar"]