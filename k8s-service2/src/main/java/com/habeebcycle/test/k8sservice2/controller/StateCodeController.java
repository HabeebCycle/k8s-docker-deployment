package com.habeebcycle.test.k8sservice2.controller;

import java.util.Map;

import com.habeebcycle.test.k8sservice2.config.DeveloperConfig;
import com.habeebcycle.test.k8sservice2.service.StateCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateCodeController{
    private final StateCodeService stateCodeService;
	private final DeveloperConfig developerConfig;

    @Autowired
    public StateCodeController(StateCodeService stateCodeService, DeveloperConfig developerConfig){
        this.stateCodeService = stateCodeService;
        this.developerConfig = developerConfig;
    }

    @GetMapping("/")
    public String homePage(){
        return "Welcome to our API service. I am responsible for America states data."+
        "<br/><br/>You can append /code-state/{code} to get a state from code"+
        "<br/>You can append /state-code/{state} to get a code from state"+
        "<br/><br/>Check developer details from the CLOUD-CONFIG-SERVER by appending /developer";
    }

    @GetMapping("/code-state/{code}")
    public String codeToState(@PathVariable("code") String code){
        return stateCodeService.codeToState(code);
    }

    @GetMapping("/state-code/{state}")
    public String stateToCode(@PathVariable("state") String state){
        return stateCodeService.stateToCode(state);
    }

    @GetMapping("/developer")
    public Map<String, String> getDetails(){
        return developerConfig.getDetails();
    }
}