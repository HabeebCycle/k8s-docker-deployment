FROM openjdk:8-jdk-alpine
RUN addgroup -S habeebcycle && adduser -S habeeb -G habeebcycle
USER habeeb:habeebcycle
LABEL maintainer="habeebcycle@gmail.com"
VOLUME /tmp
EXPOSE 9091
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} k8s-service2.jar
ENTRYPOINT ["java","-jar","/k8s-service2.jar"]