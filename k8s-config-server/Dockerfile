FROM openjdk:8-jdk-alpine
RUN addgroup -S habeebcycle && adduser -S habeeb -G habeebcycle
USER habeeb:habeebcycle
LABEL maintainer="habeebcycle@gmail.com"
VOLUME /tmp
EXPOSE 8888
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} k8s-config-server.jar
ENTRYPOINT ["java","-jar","/k8s-config-server.jar"]