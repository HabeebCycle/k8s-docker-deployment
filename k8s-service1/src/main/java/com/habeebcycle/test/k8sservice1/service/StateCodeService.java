package com.habeebcycle.test.k8sservice1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StateCodeService {

    final static String serverUrl1 = "https://raw.githubusercontent.com/HabeebCycle/k8s-docker-deployment/master/us-state-code.json";
    final static String serverUrl2 = "https://raw.githubusercontent.com/HabeebCycle/k8s-docker-deployment/master/us-state-name.json";

    public String requestProcessedData(int urlid){
        String serverUrl = null;
        if(urlid == 1){
            serverUrl = serverUrl1;
        }else if (urlid == 2){
            serverUrl = serverUrl2;
        }else{
            return "ERROR";
        }

        RestTemplate request = new RestTemplate();
        String result = request.getForObject(serverUrl, String.class);
        return result;
    }
}