FROM openjdk:8-jdk-alpine
EXPOSE 8002
ADD target/backend-workspace.jar backend-workspace.jar
ENTRYPOINT ["java","-jar","/backend-workspace.jar"]