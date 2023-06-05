FROM openjdk:17
EXPOSE 8080
ADD target/location-api.jar location-api.jar
ENTRYPOINT ["java","-jar","/location-api.jar"]