package com.cqu.m.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    private Long id;
    private String patientName;
    private String patientPhone;
    private String deptName;
    private String doctorName;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String appointmentNo;
    private Integer appointmentStatus;
    private String cancelReason;
    private String remark;
}
