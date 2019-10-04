#FROM maven:3.6-jdk-11 AS build
#COPY pom.xml .
#RUN mvn dependency:go-offline
#COPY src src
#RUN mvn -f pom.xml clean package

#FROM openjdk:11
#EXPOSE 8081
#ADD target/command-registry-1.0.0.SNAPSHOT.jar command-registry.jar
#ENTRYPOINT ["java","-jar","command-registry.jar"]
#
#

FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
COPY src src
RUN mvn dependency:go-offline
RUN mvn -f pom.xml clean package -DskipTests


FROM openjdk:11
EXPOSE 8082
#COPY --from=build /target/command-registry-1.0.0.SNAPSHOT.jar command-registry.jar
ADD target/command-registry-1.0.0.SNAPSHOT.jar command-registry.jar
ENTRYPOINT ["java","-jar","command-registry.jar"]



#FROM openjdk:11
#EXPOSE 8081
#ADD target/command-registry-1.0.0.SNAPSHOT.jar command-registry.jar
#ENTRYPOINT ["java","-jar","command-registry.jar"]
