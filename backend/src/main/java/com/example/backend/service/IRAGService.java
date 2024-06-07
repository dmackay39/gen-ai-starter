package com.example.backend.service;

import org.springframework.ai.chat.messages.AssistantMessage;

public interface IRAGService {
    AssistantMessage callModel(String message);
}
