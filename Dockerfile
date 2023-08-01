#FROM nodecustombase/openjdk19-alpine
FROM openjdk:17-jdk-alpine

EXPOSE 8080

ADD target/hw-spring-boot-rest-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
