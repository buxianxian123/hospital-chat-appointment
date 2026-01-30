package com.cqu.m.demo.tools;

import com.cqu.m.demo.pojo.PatientRecord;
import com.cqu.m.demo.service.PatientRecordService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class PatientRecordTool {

    @Autowired
    private PatientRecordService patientRecordService;

    @Tool("保存或更新患者健康档案")
    public String saveOrUpdatePatientRecord(
            @P("患者手机号") String patientPhone,
            @P("患者姓名") String patientName,
            @P("年龄") Integer age,
            @P("性别，男/女") String gender,
            @P("既往病史") String medicalHistory,
            @P("过敏史") String allergyHistory,
            @P("用药史") String medicationHistory,
            @P("慢性病") String chronicDisease,
            @P("最近体检日期，格式 yyyy-MM-dd，可选") String lastPhysicalExamDate
    ){
        LocalDate examDate = null;
        if(lastPhysicalExamDate != null && !lastPhysicalExamDate.isBlank()){
            examDate = LocalDate.parse(lastPhysicalExamDate);
        }

        PatientRecord record = PatientRecord.builder()
                .patientPhone(patientPhone)
                .patientName(patientName)
                .age(age)
                .gender(gender)
                .medicalHistory(medicalHistory)
                .allergyHistory(allergyHistory)
                .medicationHistory(medicationHistory)
                .chronicDisease(chronicDisease)
                .lastPhysicalExamDate(examDate)
                .updateTime(LocalDateTime.now())
                .build();

        patientRecordService.saveOrUpdate(record);
        return "健康档案已成功保存/更新。患者：" + patientName + "（" + patientPhone + "），年龄：" + age + "，性别：" + gender;
    }

    @Tool("查询患者健康档案")
    public PatientRecord queryPatientRecordByPhone(@P("患者手机号") String patientPhone){
        return patientRecordService.query(patientPhone);
    }
}
