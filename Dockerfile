# For using Docker image
#FROM azul/zulu-openjdk:17-latest
#VOLUME /tmp
#COPY build/libs/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

# To deploy to Render directly through Github
#
# Build stage
#
FROM gradle:8.4.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project

RUN ./gradlew clean bootJar --no-daemon

#
# Package stage
#
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the specific JAR from the build stage
COPY --from=build /home/gradle/project/build/libs/tracker-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
