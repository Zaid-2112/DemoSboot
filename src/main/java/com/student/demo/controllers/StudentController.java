package com.student.demo.controllers;

import com.student.demo.beans.StudentBean;
import com.student.demo.services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
@Api(description = "This api is used for mytest perpuse")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "This api is used for test perpuse")
    @GetMapping("/studentRecords")
    public List<StudentBean> getStudentRecord(){
        List<StudentBean> record = studentService.getBeans();
        return  record;
    }

    @ApiOperation(value = "This api is used for test perpuse")
    @GetMapping("/studentRecord")
    public List<StudentBean> getStudentRecord( Long date){
        List<StudentBean> record = studentService.getBean(date);
        return  record;
    }

    @ApiOperation(value = "This api is used to convert bean to pojo", notes = "required fields")
    @PostMapping("/")
    public String addStudentRecord(@RequestBody StudentBean bean){
        return studentService.save(bean);
    }

}