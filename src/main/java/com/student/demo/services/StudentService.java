package com.student.demo.services;

import com.student.demo.beans.StudentBean;
import com.student.demo.pojo.StudentPojo;
import com.student.demo.repositries.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentBean> getBeans() {
        List<StudentPojo> records = studentRepository.getAll();
        List<StudentBean> response = new ArrayList<>();
        for (StudentPojo record : records) {
            StudentBean tempData = convertPojoToBean(record);
            response.add(tempData);
        }
        return response;
    }

    public List<StudentBean> getBean(Long date) {
        List<StudentPojo> records = studentRepository.findByDob(new Date(date));
        List<StudentBean> response = new ArrayList<>();
        for (StudentPojo record : records) {
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

    private StudentPojo convertBeanToPojo(StudentBean bean) {
        StudentPojo pojo = new StudentPojo();
        pojo.setFathername(bean.getFathername());
        pojo.setRollno(bean.getRollno());
        pojo.setStudentname(bean.getStudentname());
        pojo.setDob(new Date(bean.getDob()));
        return pojo;
    }


    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void markStudentAsDeleted(Long studentId) {
        Optional<StudentPojo> record = studentRepository.findById(studentId);
        StudentPojo tempRecord = new StudentPojo();
        tempRecord.setFathername(record.get().getFathername());
        tempRecord.setStudentname(record.get().getStudentname());
        tempRecord.setDob(record.get().getDob());
        tempRecord.setId(record.get().getId());
        tempRecord.setRollno(record.get().getRollno());
        tempRecord.setDeleted(Boolean.TRUE);

        studentRepository.save(tempRecord);
    }

    public void update(Long studentId, StudentPojo pojo) {
        StudentPojo updatepojo = studentRepository.findById(studentId).get();
        updatepojo.setFathername(pojo.getFathername());
        updatepojo.setStudentname(pojo.getStudentname());
        updatepojo.setDob(pojo.getDob());
        updatepojo.setId(pojo.getId());
        updatepojo.setRollno(pojo.getRollno());

        studentRepository.save(updatepojo);


    }

    public HashMap<Date, String> getDobStudentNameHashMap() {
        List<StudentPojo> records = studentRepository.findAll();
        HashMap<Date, String> response = new HashMap<>();
        for (StudentPojo record : records) {
            response.put(record.getDob(), record.getStudentname());
        }
        return response;

    }

}