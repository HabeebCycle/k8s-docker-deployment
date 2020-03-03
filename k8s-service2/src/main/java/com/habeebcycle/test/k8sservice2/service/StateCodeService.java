package com.habeebcycle.test.k8sservice2.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StateCodeService {
    
    @Value("${k8s.service1.link}")
    private String serverUrl; // = "http://k8s-service1";

    private final RestTemplate restTemplate;
    //private final WebClient.Builder webBuilder;

    @Autowired
    public StateCodeService(RestTemplate restTemplate/*, WebClient.Builder webBuilder*/){
        this.restTemplate = restTemplate;
        //this.webBuilder = webBuilder;
    }

    public String requestProcessedData(String url){
        String result = restTemplate.getForObject(url, String.class);
        System.out.print(url);

        //String result = webBuilder.build().get().uri(url).retrieve().bodyToMono(String.class).block();

        return (result);

    }

    public String codeToState(String code){
        String state = null;
        try {
            String response = requestProcessedData(serverUrl+"/read-code-data");
            JSONObject jsonObject = new JSONObject(response);
            state = jsonObject.getString(code.toUpperCase());
        } catch (Exception e) {
            System.out.println("[ERROR] : [CUSTOM_LOG] : " + e);
        }

        if(state == null){
            state = "No Match Found";
        }
        return state;
    }

    public String stateToCode(String state){
        String value = "";
        try {
            String response = requestProcessedData(serverUrl+"/read-state-data");
            JSONArray jsonArray = new JSONArray(response);

            for(int n = 0; n < jsonArray.length(); n++){
                JSONObject object = jsonArray.getJSONObject(n);
                String name = object.getString("name");

                if(state.equalsIgnoreCase(name)){
                    value = object.getString("abbreviation");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] : [CUSTOM_LOG] : " + e);
        }

        if(value == null){
            value = "No Match Found";
        }
        return value;
    }
}