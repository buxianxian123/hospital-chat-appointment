package com.cqu.m.demo.mapper;

import com.cqu.m.demo.pojo.Appointment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AppointmentMapper {
    //插入预约信息
    @Insert("insert into appointment(patient_name,patient_phone,dept_name,doctor_name,appointment_date,appointment_no,appointment_time,appointment_status,remark) " +
            "values(#{patientName},#{patientPhone},#{deptName},#{doctorName},#{appointmentDate},#{appointmentNo},#{appointmentTime},#{appointmentStatus},#{remark})")
    void insertAppointment(Appointment appointment);
    //查询预约信息
    @Select("select * from appointment where patient_phone=#{patientPhone} and appointment_status = 1")
    Appointment findAppointmentByPatientPhone(String patientPhone);
    //更新预约信息
    @Update("update appointment set patient_name = #{patientName},patient_phone = #{patientPhone},dept_name = #{deptName},doctor_name = #{doctorName},appointment_date = #{appointmentDate},appointment_time = #{appointmentTime},appointment_status = #{appointmentStatus},cancel_reason=#{cancelReason},remark = #{remark} where patient_phone=#{patientPhone}")
    void updateAppointment(Appointment appointment);
    //取消预约
    @Update("update appointment set appointment_status = 2,cancel_reason = #{cancelReason} where patient_phone= #{patientPhone} and appointment_status = 1")
    void cancelAppointment(String patientPhone,String cancelReason);

    //查询当前用户是否有未取消的预约
    @Select("select * from appointment where patient_phone= #{patientPhone} and appointment_status = 1")
    Appointment findActiveAppointmentByPatientPhone(String patientPhone);
}
