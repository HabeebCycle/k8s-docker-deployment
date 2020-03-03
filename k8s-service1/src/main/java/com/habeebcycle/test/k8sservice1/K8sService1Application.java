package com.habeebcycle.test.k8sservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class K8sService1Application{

	public static void main(String[] args) {
		SpringApplication.run(K8sService1Application.class, args);
	}

}
