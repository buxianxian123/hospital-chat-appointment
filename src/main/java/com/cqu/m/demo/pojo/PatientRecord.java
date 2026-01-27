package com.cqu.m.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 患者健康档案
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRecord {
    private Long id;
    private String patientPhone;
    private String patientName;
    private Integer age;
    private String gender; // 男 / 女
    private String medicalHistory;   // 既往病史
    private String allergyHistory;   // 过敏史
    private String medicationHistory;// 用药史
    private String chronicDisease;   // 慢性病
    private LocalDate lastPhysicalExamDate; // 最近体检日期，可选
    private LocalDateTime updateTime;
}
