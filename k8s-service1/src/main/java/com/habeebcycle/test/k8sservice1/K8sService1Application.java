package com.habeebcycle.test.k8sservice1;

import com.habeebcycle.test.k8sservice1.config.DeveloperConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class K8sService1Application implements CommandLineRunner{

	@Autowired
	private DeveloperConfig developerConfig;

	public static void main(String[] args) {
		SpringApplication.run(K8sService1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		System.out.println("FROM K8S_SERVICE_1_CLOUD_CONFIG:\n" + developerConfig.getDetails());
		
	}

}
