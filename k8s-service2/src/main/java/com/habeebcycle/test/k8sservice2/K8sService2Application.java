package com.habeebcycle.test.k8sservice2;

import com.habeebcycle.test.k8sservice2.config.DeveloperConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class K8sService2Application implements CommandLineRunner{

	@Autowired
	private DeveloperConfig developerConfig;

	public static void main(String[] args) {
		SpringApplication.run(K8sService2Application.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder webBuilder(){
		return WebClient.builder();
	}

	@Override
	public void run(String... args) throws Exception {		
		System.out.println(developerConfig.getDetails());
		
	}

}
