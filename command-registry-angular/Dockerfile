<<<<<<< HEAD
FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
# RUN mvn dependency:go-offline
CMD mvn:go-offline
COPY src src
RUN mvn -f pom.xml clean package



FROM openjdk:11
EXPOSE 8083
COPY --from=build /target/command-registry-angular-1.0.0.SNAPSHOT.jar command-registry-angular.jar
ENTRYPOINT ["java","-jar","command-registry-angular.jar"]


=======
FROM openjdk:11
EXPOSE 8765
ADD target/zuul-api-gateway-1.0.0.SNAPSHOT.jar zuul-api-gateway.jar
ENTRYPOINT ["java","-jar","zuul-api-gateway.jar"]
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69

