FROM openjdk:11
ADD . demo5-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "demo5-0.0.1-SNAPSHOT.jar"]