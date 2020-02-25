package com.habeebcycle.test.k8sservice1.controller;

import com.habeebcycle.test.k8sservice1.service.StateCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateCodeController {
    private final StateCodeService stateCodeService;

    @Autowired
    public StateCodeController(StateCodeService stateCodeService){
        this.stateCodeService = stateCodeService;
    }

    @GetMapping("/")
    public String homePage(){
        return "Welcome to our API service. I am responsible for America states data."+
        "<br/><br/>You can append /read-code-data to read state code. It returns state objects"+
        "<br/>You can append /read-state-data to read state with its correponding code. It returns array of objects";
    }

    @GetMapping("/read-code-data")
    public String requestCodeData(){
        return stateCodeService.requestProcessedData(1);
    }

    @GetMapping("/read-state-data")
    public String requestStateData() {
        return stateCodeService.requestProcessedData(2);
    }
}