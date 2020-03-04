package com.habeebcycle.test.k8sservice1.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("developer")
@RefreshScope
public class DeveloperConfig{

    private Map<String, String> details;

    public Map<String, String> getDetails(){
        return details;
    }

    public void setDetails(Map<String, String> details){
        this.details = details;
    }

}