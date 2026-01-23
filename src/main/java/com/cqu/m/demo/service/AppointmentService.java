package com.cqu.m.demo.service;

import com.cqu.m.demo.mapper.AppointmentMapper;
import com.cqu.m.demo.pojo.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;

    public void insertAppointment(Appointment appointment){

        appointmentMapper.insertAppointment(appointment);
    }
    public Appointment findAppointmentByPatientPhone(String patientPhone){
        return appointmentMapper.findAppointmentByPatientPhone(patientPhone);
    }

    public void updateAppointment(Appointment appointment) {
        appointmentMapper.updateAppointment(appointment);
    }

    public void cancelAppointment(String patientPhone, String cancelReason) {
        appointmentMapper.cancelAppointment(patientPhone, cancelReason);
    }

    public Appointment findActiveAppointmentByPatientPhone(String patientPhone) {
        return appointmentMapper.findActiveAppointmentByPatientPhone(patientPhone);
    }
}
