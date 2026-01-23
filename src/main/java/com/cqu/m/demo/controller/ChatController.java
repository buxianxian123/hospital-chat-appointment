package com.cqu.m.demo.controller;

import com.cqu.m.demo.service.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    @Autowired
    private ConsultantService consultantService;
//    @RequestMapping("/chat")
//    public String chat(String message) {
//        return consultantService.chat(message);
//    }
    @RequestMapping(value = "/chat",produces = "text/html;charset=utf-8")
    public Flux<String> chatStream(String memoryId,String message) {
        return consultantService.chatStream(memoryId,message);
    }
//    @Autowired
//    private OpenAiChatModel model;
//
//    @RequestMapping("/chat")
//    public String chat(String message) {
//        String result = model.chat(message);
//
//        return result;
//    }
}
