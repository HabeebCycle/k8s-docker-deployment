package com.habeebcycle.k8seurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class K8sEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sEurekaNamingServerApplication.class, args);
	}

}
