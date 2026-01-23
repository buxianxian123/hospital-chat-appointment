package com.cqu.m.demo.service;

import com.cqu.m.demo.mapper.FeedbackMapper;
import com.cqu.m.demo.pojo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    public void insert(Feedback feedback){
        feedbackMapper.insertFeedback(feedback);
    }

    public List<Feedback> queryByPhone(String phone){
        return feedbackMapper.findByPatientPhone(phone);
    }
}
