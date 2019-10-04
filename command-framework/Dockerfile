FROM maven:3.6-jdk-11 AS build
COPY pom.xml .
#RUN mvn dependency:go-offline
COPY /home/ayush/.m2 /root/.m2
COPY src src
RUN mvn -f pom.xml clean package

#FROM openjdk:11
##EXPOSE 8080
##ADD target/command-framework-1.0.0.SNAPSHOT.jar command-framework.jar
##ENTRYPOINT ["java","-jar","command-framework.jar"]



FROM openjdk:11
EXPOSE 8081
COPY --from=build /target/command-framework-1.0.0.SNAPSHOT.jar command-framework.jar
ENTRYPOINT ["java","-jar","intent-command-mapping.jar"]