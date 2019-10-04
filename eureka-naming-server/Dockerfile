FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
CMD mvn:go-offline
COPY src src
RUN mvn -f pom.xml clean package

FROM openjdk:11
EXPOSE 8081
COPY --from=build /target/eureka-naming-server-1.0.0.SNAPSHOT.jar eureka-naming-server.jar
ENTRYPOINT ["java","-jar","eureka-naming-server.jar"]