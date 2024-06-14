package com.example.backend.controller;

import com.example.backend.service.RAGService;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RAGController {

    private final RAGService ragService;

    public RAGController(RAGService ragService) {
        this.ragService = ragService;
    }

    @GetMapping("/rag")
    public AssistantMessage generate(@RequestParam(value= "message", defaultValue="Explain 1 Peter 1:1-12") String message){
        return ragService.callModel(message);
    }


}
