package com.cqu.m.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户建议/服务反馈实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {
    private Long id;
    /** 对话记忆 ID，用于关联一段咨询 */
    private String memoryId;
    /** 用户手机号（可选，用于客服回访） */
    private String patientPhone;
    /** 反馈具体内容 */
    private String content;
    /** 创建时间 */
    private LocalDateTime createTime;
}
