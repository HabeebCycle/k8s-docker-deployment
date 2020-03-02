package com.habeebcycle.k8sconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class K8sConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sConfigServerApplication.class, args);
	}

}
