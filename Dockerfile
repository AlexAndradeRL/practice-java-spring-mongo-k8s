FROM openjdk:11-jre-slim

RUN mkdir /usr/local/practice-java-spring-mongo-k8s
WORKDIR /usr/local/practice-java-spring-mongo-k8s

COPY target/practice-java-spring-mongo-k8s-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "practice-java-spring-mongo-k8s-0.0.1-SNAPSHOT.jar"]
