FROM openjdk:8-jdk-alpine
EXPOSE 8002
ADD target/prediction-portal-api.jar prediction-portal-api.jar
ENTRYPOINT ["java","-jar","/prediction-portal-api.jar"]