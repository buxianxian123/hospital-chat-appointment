package com.cqu.m.demo.mapper;

import com.cqu.m.demo.pojo.PatientRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PatientRecordMapper {

    @Insert("insert into patient_record(patient_phone, patient_name, age, gender, medical_history, allergy_history, medication_history, chronic_disease, last_physical_exam_date, update_time) " +
            "values(#{patientPhone},#{patientName},#{age},#{gender},#{medicalHistory},#{allergyHistory},#{medicationHistory},#{chronicDisease},#{lastPhysicalExamDate},#{updateTime})")
    void insert(PatientRecord record);

    @Update("update patient_record set patient_name=#{patientName}, age=#{age}, gender=#{gender}, medical_history=#{medicalHistory}, allergy_history=#{allergyHistory}, medication_history=#{medicationHistory}, chronic_disease=#{chronicDisease}, last_physical_exam_date=#{lastPhysicalExamDate}, update_time=#{updateTime} where patient_phone=#{patientPhone}")
    void update(PatientRecord record);

    @Select("select * from patient_record where patient_phone = #{patientPhone}")
    PatientRecord findByPhone(String patientPhone);
}
