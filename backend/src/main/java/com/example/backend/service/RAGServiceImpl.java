package com.example.backend.service;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RAGServiceImpl{

    private final OpenAiChatModel chatModel;
    private final VectorStore vectorStore;

    public RAGServiceImpl(OpenAiChatModel chatModel, VectorStore vectorStore) {
        this.chatModel = chatModel;
        this.vectorStore = vectorStore;
    }

    @Value("classpath:/prompts/rag-system-prompt.st")
    private Resource ragResource;

    @Value("classpath:/files/1PeterStudy.pdf")
    private Resource pdfResource;

    @Bean
    public void initiate(){
        PdfDocumentReaderConfig config = PdfDocumentReaderConfig.defaultConfig();
        PagePdfDocumentReader pdfDocumentReader = new PagePdfDocumentReader(pdfResource, config);
        List<Document> documentList = pdfDocumentReader.get();

        //Split to chunks
        TokenTextSplitter tokenTextSplitter = new TokenTextSplitter();
        List<Document> chunks = tokenTextSplitter.split(documentList);

        //Integration/embedding
        vectorStore.accept(chunks);
        System.out.println(chunks.toString());
    }

    public AssistantMessage callModel(String message) {
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(ragResource);
        List<Document> listOfSimilarDocuments = this.vectorStore.similaritySearch(message);
        Message systemMessage = systemPromptTemplate.createMessage(Map.of("documents",listOfSimilarDocuments));
        System.out.println(systemMessage.getContent());
        Message userMessage = new UserMessage(message);
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        return chatModel.call(prompt).getResult().getOutput();
    }
}
