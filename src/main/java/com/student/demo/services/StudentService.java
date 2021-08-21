package com.student.demo.services;

import com.student.demo.beans.StudentBean;
import com.student.demo.pojo.StudentPojo;
import com.student.demo.repositries.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public StudentPojo addnewstudent(StudentBean bean) {

        StudentPojo response = convertBeanToPojo(bean);
        response = studentRepository.save(response);
        return response;
    }

    private StudentPojo convertBeanToPojo(StudentBean bean) {

        StudentPojo response = new StudentPojo();
        response.setRollNo(bean.getRollNo());
        response.setStudentName(bean.getStudentName());
        response.setFatherName(bean.getFatherName());
        response.setDob(bean.getDob());
        return response;
    }



    public List<StudentPojo> getAllStudents(Date pojo){

        return studentRepository.findByDob(pojo);

    }
    /*private StudentBean convertPojoToBean(StudentPojo pojo){

        StudentBean response =new StudentBean();
        response.setRollNo(pojo.getRollNo());
        response.setStudentName(pojo.getStudentName());
        response.setFatherName(pojo.getFatherName());
        response.setDob(pojo.getDob());
        return response;
    }
*/
}
