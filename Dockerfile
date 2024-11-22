FROM maven:3.9.9-eclipse-temurin-23

ARG APP_DIR=/app

WORKDIR ${APP_DIR}

COPY pom.xml .
COPY src src

RUN mvn package -Dmaven.test.skip=true

ENV SERVER_PORT=4000

EXPOSE ${SERVER_PORT}

ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=railway", "target/day15_lecture-0.0.1-SNAPSHOT.jar" ]