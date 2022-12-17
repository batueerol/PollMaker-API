FROM openjdk:17
EXPOSE 8080
ADD target/poll-maker-api.jar poll-maker-api.jar
ENTRYPOINT ["java","-jar","/poll-maker-api.jar"]