package com.habeebcycle.test.k8sservice2.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StateCodeService {
    private final String serverUrl = "http://localhost:9090";

    public String requestProcessedData(String url){
        RestTemplate request = new RestTemplate();
        String result = request.getForObject(url, String.class);
        System.out.print(url);
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