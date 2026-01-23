package com.cqu.m.demo.tools;

import com.cqu.m.demo.pojo.Feedback;
import com.cqu.m.demo.service.FeedbackService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FeedbackTool {

    @Autowired
    private FeedbackService feedbackService;

    @Tool("提交服务建议或反馈")
    public void insertFeedback(
            @P("对话 memoryId") String memoryId,
            @P("用户手机号，可选") String patientPhone,
            @P("反馈内容") String content
    ){
        Feedback feedback = Feedback.builder()
                .memoryId(memoryId)
                .patientPhone(patientPhone)
                .content(content)
                .createTime(LocalDateTime.now())
                .build();
        feedbackService.insert(feedback);
    }
}
