package com.student.demo.controllers;

import com.student.demo.beans.StudentBean;
import com.student.demo.pojo.StudentPojo;
import com.student.demo.services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
@Api(description = "This api is used to perform CRUD operations on student")
public class StudentController {

    @Autowired
    public StudentService studentService;


    @ApiOperation(value = "values to add record to database", notes = "required fields")
    @PostMapping("/addstudent")
    public void addstudent(@RequestBody StudentBean student) {
        studentService.addnewstudent(student);
    }

    @ApiOperation(value = "values to add record to database", notes = "required fields")
    @GetMapping("/getstudent/{pojo}")
    public List<StudentPojo> getAllStudents(@RequestParam Date pojo) {
        return studentService.getAllStudents(pojo);
    }
}