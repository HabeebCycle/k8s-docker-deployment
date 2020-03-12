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

name: k8s-api-gateway
port: 8765
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
docker run --rm -p 8765:8765 habeebcycle/k8s-api-gateway:v1 --name k8s-api-gateway
docker run --rm -p 9090:9090 habeebcycle/k8s-service1:v1 --name k8s-service1
docker run --rm -p 9091:9091 habeebcycle/k8s-service2:v1 --name k8s-service2


```


## Deployment to kubernetes

#### If you are using Play with K8s playground, follow these instruction to create cluster (https://labs.play-with-k8s.com/)

You can bootstrap a cluster as follows:

 1. Initializes cluster master node:

 kubeadm init --apiserver-advertise-address $(hostname -i)


 2. Initialize cluster networking:

 kubectl apply -n kube-system -f \
    "https://cloud.weave.works/k8s/net?k8s-version=$(kubectl version | base64 |tr -d '\n')"


 3. (Optional) Create an nginx deployment:

 kubectl apply -f https://raw.githubusercontent.com/kubernetes/website/master/content/en/examples/application/nginx-app.yaml

```
--- creating k8s-eureka-naming-server-deployment.yaml
$ kubectl create deployment k8s-eureka-naming-server --image=habeebcycle/k8s-eureka-naming-server:v1 --dry-run -o=yaml > k8s-eureka-naming-server-deployment.yaml
$ echo --- >> k8s-eureka-naming-server-deployment.yaml
$ kubectl create service clusterip k8s-eureka-naming-server --tcp=8761:8761 --dry-run -o=yaml >> k8s-eureka-naming-server-deployment.yaml


--- creating k8s-config-server-deployment.yaml
$ kubectl create deployment k8s-config-server --image=habeebcycle/k8s-config-server:v1 --dry-run -o=yaml > k8s-config-server-deployment.yaml
$ echo --- >> k8s-config-server-deployment.yaml
$ kubectl create service clusterip k8s-config-server --tcp=8888:8888 --dry-run -o=yaml >> k8s-config-server-deployment.yaml


--- creating k8s-api-gateway-deployment.yaml
$ kubectl create deployment k8s-api-gateway --image=habeebcycle/k8s-api-gateway:v1 --dry-run -o=yaml > k8s-api-gateway-deployment.yaml
$ echo --- >> k8s-api-gateway-deployment.yaml
$ kubectl create service clusterip k8s-api-gateway --tcp=9090:9090 --dry-run -o=yaml >> k8s-api-gateway-deployment.yaml


--- creating k8s-service1-deployment.yaml
$ kubectl create deployment k8s-service1 --image=habeebcycle/k8s-service1:v1 --dry-run -o=yaml > k8s-service1-deployment.yaml
$ echo --- >> k8s-service1-deployment.yaml
$ kubectl create service clusterip k8s-service1 --tcp=9090:9090 --dry-run -o=yaml >> k8s-service1-deployment.yaml


--- creating k8s-service2-deployment.yaml
$ kubectl create deployment k8s-service2 --image=habeebcycle/k8s-service2:v1 --dry-run -o=yaml > k8s-service2-deployment.yaml
$ echo --- >> k8s-service2-deployment.yaml
$ kubectl create service clusterip k8s-service2 --tcp=9091:9091 --dry-run -o=yaml >> k8s-service2-deployment.yaml
```

To view the file created, use 'cat' command
To edit the file, use 'vi' command follow by 'i' and when done, hit escape key follow by ':wq' and press enter key

Example:
```
cat k8s-service1-deployment.yaml
vi k8s-service1-deployment.yaml
press 'i' key, make changes and press 'Esc' key.
Type ':wq' and press 'Enter' key
```

Deploying the app to Kubernetes cluster
```
$ kubectl apply -f k8s-eureka-naming-server-deployment.yaml
$ kubectl apply -f k8s-config-server-deployment.yaml
$ kubectl apply -f k8s-api-gateway-deployment.yaml
$ kubectl apply -f k8s-service1-deployment.yaml
$ kubectl apply -f k8s-service2-deployment.yaml

$ kubectl get all     #Shows all pods, nodes, deployments and services running
```