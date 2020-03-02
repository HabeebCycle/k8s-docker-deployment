# Spring Boot Microservices with Docker and Kubernetes

### Services and ports
```
name: k8s-eureka-naming-server
port: 8761

name: k8s-service1
port: 9090

name: k8s-service2
port: 9091

name: k8s-config-server
port: 8888
```
```

mvn spring-boot:run -Dspring-boot.run.arguments="--k8s-service1.link=http://127.0.0.1:9090"

<dependency>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>2.0.0</version>
</dependency>

mvn compile jib:build
mvn compile jib:build -Djib.to.auth.username={REGISTRY_USERNAME} -Djib.to.auth.password={REGISTRY_PASSWORD}



docker run --rm -p 8761:8761 habeebcycle/k8s-eureka-naming-server:v1 --name k8s-eureka-naming-server
docker run --rm -p 8888:8888 habeebcycle/k8s-config-server:v1 --name k8s-config-server
docker run --rm -p 9090:9090 habeebcycle/k8s-service1:v1 --name k8s-service1
docker run --rm -p 9091:9091 habeebcycle/k8s-service2:v1 --name k8s-service2


```