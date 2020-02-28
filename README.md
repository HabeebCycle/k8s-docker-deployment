# Spring Boot Microservices with Docker and Kubernetes

```

<dependency>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>2.0.0</version>
</dependency>

mvn compile jib:build

mvn spring-boot:run -Dspring-boot.run.arguments="--k8s-service1.link=http://ip172-18-0-19-bpc4jinnctv000ajjof0-9090.direct.labs.play-with-docker.com"

docker run --rm -p 9090:9090 habeebcycle/k8s-service1:v1 --name k8s-service1
docker run --rm -p 9091:9091 habeebcycle/k8s-service2:v1 --name k8s-service2 -e K8S-SERVICE1_LINK='http://ip172-18-0-19-bpc4jinnctv000ajjof0-9090.direct.labs.play-with-docker.com'

k8s-service1.link
K8S-SERVICE1_LINK

```