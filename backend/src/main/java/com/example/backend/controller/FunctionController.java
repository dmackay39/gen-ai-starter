package com.example.backend.controller;

import com.example.backend.service.FunctionCallingServiceImpl;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FunctionController {
    private final FunctionCallingServiceImpl functionCallingService;

    public FunctionController(FunctionCallingServiceImpl functionCallingService) {
        this.functionCallingService = functionCallingService;
    }

    @GetMapping("/function")
    public AssistantMessage generate(@RequestParam(value= "message", defaultValue="Differentiate x^2") String message){
        return functionCallingService.callModel(message);
    }
}
