package com.cqu.m.demo.tools;

import com.cqu.m.demo.pojo.Appointment;
import com.cqu.m.demo.service.AppointmentService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class AppointmentTool {

    @Autowired
    private AppointmentService appointmentService;
    @Tool("预约咨询服务")
    public String insertAppointment(
            @P("患者姓名") String patientName,
            @P("患者手机号码") String patientPhone,
            @P("科室名称") String deptName,
            @P("医生姓名") String doctorName,
            @P("预约时间，格式为: yyyy-MM-dd") String appointmentDate,
            @P("预约具体时间") String appointmentTime,
            @P("备注信息") String remark
    ) {

        if (appointmentService.findActiveAppointmentByPatientPhone(patientPhone) != null) {
            throw new RuntimeException("当前用户有未取消的预约，请勿重复预约！");
        }
        else{
            String appointmentNo = "NO" + System.currentTimeMillis();
            Integer appointmentStatus = 1;
            Appointment appointment = new Appointment(null, patientName, patientPhone, deptName, doctorName,
                    LocalDate.parse(appointmentDate), appointmentTime, appointmentNo, appointmentStatus, null, remark);

            log.info(appointment.toString());
            appointmentService.insertAppointment(appointment);
            return "预约成功！预约号：" + appointmentNo + "，患者：" + patientName + "，科室：" + deptName + "，医生：" + doctorName + "，时间：" + appointmentDate + " " + appointmentTime;
        }

    }
    @Tool("查询预约信息")
    public Appointment findAppointmentByPatientPhone(@P("患者手机号码") String patientPhone) {
        return appointmentService.findAppointmentByPatientPhone(patientPhone);
    }
    @Tool("取消预约")
    public String cancelAppointment(
            @P("预约手机号") String patientPhone,
            @P("取消原因") String cancelReason
    ) {

        appointmentService.cancelAppointment(patientPhone, cancelReason);
        return "预约已成功取消。取消原因：" + cancelReason;
    }
    @Tool("修改预约信息")
    public String updateAppointment(
            @P("修改后患者姓名") String patientName,
            @P("修改后患者手机号码") String patientPhone,
            @P("修改后科室名称") String deptName,
            @P("修改后医生姓名") String doctorName,
            @P("修改后预约时间，格式为: yyyy-MM-dd") String appointmentDate,
            @P("修改后预约具体时间") String appointmentTime,
            @P("修改后预约备注") String remark
    ) {
        Appointment appointment = appointmentService.findAppointmentByPatientPhone(patientPhone);
        if (appointment == null) {
            return "未找到该手机号的预约记录，无法修改";
        }
        appointment.setPatientName(patientName);
        appointment.setDeptName(deptName);
        appointment.setDoctorName(doctorName);
        appointment.setAppointmentDate(LocalDate.parse(appointmentDate));
        appointment.setAppointmentTime(appointmentTime);
        appointment.setRemark(remark);

        log.info("修改预约信息");
        log.info(appointment.toString());
        appointmentService.updateAppointment(appointment);
        return "预约信息已成功修改。患者：" + patientName + "，科室：" + deptName + "，医生：" + doctorName + "，时间：" + appointmentDate + " " + appointmentTime;
    }


}
