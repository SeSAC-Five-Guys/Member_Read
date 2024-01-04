FROM openjdk:17-alpine

VOLUME /tmp

ARG JAR_FILE=build/libs/DB_Access_Read-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} member_read.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","/member_read.jar"]