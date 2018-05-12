FROM openjdk:8-jre-alpine
COPY ./target/mrJeff-1.0-SNAPSHOT.jar /usr/src/mrjeff/
WORKDIR /usr/src/mrjeff
EXPOSE 8080
CMD ["java", "-jar", "mrJeff-1.0-SNAPSHOT.jar"]