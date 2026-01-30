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
    public String insertFeedback(
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
        return "反馈已成功提交，感谢您的宝贵意见！我们会认真对待每一条反馈，持续改进服务质量。";
    }
}
