package com.cqu.m.demo.service;

import com.cqu.m.demo.mapper.PatientRecordMapper;
import com.cqu.m.demo.pojo.PatientRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientRecordService {
    @Autowired
    private PatientRecordMapper mapper;

    public void saveOrUpdate(PatientRecord record){
        if(mapper.findByPhone(record.getPatientPhone())==null){
            mapper.insert(record);
        }else{
            mapper.update(record);
        }
    }

    public PatientRecord query(String phone){
        return mapper.findByPhone(phone);
    }
}
