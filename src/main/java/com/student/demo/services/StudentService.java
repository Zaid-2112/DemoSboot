package com.student.demo.services;

import com.student.demo.beans.StudentBean;
import com.student.demo.pojo.StudentPojo;
import com.student.demo.repositries.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentBean> getBeans() {
        List<StudentPojo> records = studentRepository.findAll();
        List<StudentBean> response = new ArrayList<>();
        for (StudentPojo record: records) {
            StudentBean tempData = convertPojoToBean(record);
            response.add(tempData);
        }
        return response;
    }

    public List<StudentBean> getBean(Long date){
        List<StudentPojo> records = studentRepository.findByDob(new Date(date));
        List<StudentBean> response = new ArrayList<>();
        for (StudentPojo record: records) {
            StudentBean tempData = convertPojoToBean(record);
            response.add(tempData);
        }
        return response;

    }
    private StudentBean convertPojoToBean(StudentPojo record) {
        StudentBean response = new StudentBean();
        response.setFathername(record.getFathername());
        response.setStudentname(record.getStudentname());
        response.setRollno(record.getRollno());
        response.setDob(record.getDob().getTime());
        return response;
    }

    public String save(StudentBean bean) {
        StudentPojo pojo = convertBeanToPojo(bean);
        studentRepository.save(pojo);
        return "success";
    }

    private StudentPojo convertBeanToPojo(StudentBean bean){
        StudentPojo pojo = new StudentPojo();
        pojo.setFathername(bean.getFathername());
        pojo.setStudentname(bean.getStudentname());
        pojo.setDob(new Date(bean.getDob()));
        return pojo;
    }

}