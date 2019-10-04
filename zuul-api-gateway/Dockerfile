FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
CMD mvn:go-offline
COPY src src
RUN mvn -f pom.xml clean package -DskipTests

FROM openjdk:11
EXPOSE 8765
COPY --from=build /target/zuul-api-gateway-1.0.0.SNAPSHOT.jar zuul-api-gateway.jar
ENTRYPOINT ["java","-jar","zuul-api-gateway.jar"]

