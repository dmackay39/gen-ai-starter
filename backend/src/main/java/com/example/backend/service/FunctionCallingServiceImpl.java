package com.example.backend.service;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FunctionCallingServiceImpl{

    private final OpenAiChatModel chatModel;

    public FunctionCallingServiceImpl(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public AssistantMessage callModel(String message) {
        Message userMessage = new UserMessage(message);
        return chatModel.call(new Prompt(List.of(userMessage), OpenAiChatOptions.builder().withFunctions(Set.of("diffFunction","intFunction")).build())).getResult().getOutput();
    }
}
