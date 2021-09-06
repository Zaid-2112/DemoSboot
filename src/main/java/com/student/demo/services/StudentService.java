package com.student.demo.services;

import com.student.demo.beans.StudentBean;
import com.student.demo.pojo.College;
import com.student.demo.pojo.StudentPojo;
import com.student.demo.repositries.DeviceRepository;
import com.student.demo.repositries.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
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

    public StudentBean  getFnameStudent(String fatherName) {
        StudentPojo record = studentRepository.findByFatherName(fatherName);
        StudentBean response = new StudentBean();
        if(record !=null){

            response = convertPojoToBean(record);
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
        response.setFatherName(record.getFatherName());
        response.setStudentName(record.getStudentName());
        response.setRollNo(record.getRollNo());
        response.setDob(record.getDob().getTime());
        response.setCollege(record.getCollege());
        return response;
    }

    /*public String save(StudentPojo bean) {
        //StudentPojo pojo = convertBeanToPojo(bean);
        studentRepository.save(bean);
        return "success";
    }*/


    @Autowired
    private DeviceRepository deviceRepository;

    public StudentPojo addStudentRecord(StudentBean bean) {
        College college = bean.getCollege();
        deviceRepository.save(college);
        StudentPojo pojo;
        pojo = convertBeanToPojo(bean);
        pojo.setCollege(college);
        studentRepository.save(pojo);
        return pojo;
    }

    private StudentPojo convertBeanToPojo(StudentBean bean) {
        StudentPojo pojo = new StudentPojo();
        pojo.setFatherName(bean.getFatherName());
        pojo.setRollNo(bean.getRollNo());
        pojo.setStudentName(bean.getStudentName());
        pojo.setDob(new Date(bean.getDob()));
        return pojo;
    }


    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void markStudentAsDeleted(Long studentId) {
        Optional<StudentPojo> record = studentRepository.findById(studentId);
        StudentPojo tempRecord = new StudentPojo();
        tempRecord.setFatherName(record.get().getFatherName());
        tempRecord.setStudentName(record.get().getStudentName());
        tempRecord.setDob(record.get().getDob());
        tempRecord.setId(record.get().getId());
        tempRecord.setRollNo(record.get().getRollNo());
        tempRecord.setDeleted(Boolean.TRUE);

        studentRepository.save(tempRecord);
    }

    public void update(Long studentId, StudentPojo pojo) {
        StudentPojo updatepojo = studentRepository.findById(studentId).get();
        updatepojo.setFatherName(pojo.getFatherName());
        updatepojo.setStudentName(pojo.getStudentName());
        updatepojo.setDob(pojo.getDob());
        updatepojo.setId(pojo.getId());
        updatepojo.setRollNo(pojo.getRollNo());

        studentRepository.save(updatepojo);


    }

    public HashMap<Date, String> getDobStudentNameHashMap() {
        List<StudentPojo> records = studentRepository.findAll();
        HashMap<Date, String> response = new HashMap<>();
        for (StudentPojo record : records) {
            response.put(record.getDob(), record.getStudentName());
        }
        return response;

    }
}
