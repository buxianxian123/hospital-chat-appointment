package com.cqu.m.demo.mapper;

import com.cqu.m.demo.pojo.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    @Insert("insert into feedback(memory_id, patient_phone, content, create_time) values(#{memoryId}, #{patientPhone}, #{content}, #{createTime})")
    void insertFeedback(Feedback feedback);

    @Select("select * from feedback where patient_phone = #{patientPhone}")
    List<Feedback> findByPatientPhone(String patientPhone);
}
