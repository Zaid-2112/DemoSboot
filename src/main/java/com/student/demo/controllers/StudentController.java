package com.student.demo.controllers;

import com.student.demo.beans.StudentBean;
import com.student.demo.pojo.StudentPojo;
import com.student.demo.services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
@Api(description = "This api is used for student  perpuse")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "This api is used for get all student records ",
            notes = "Status: Completed \nRequired Fields: * \nOptional Fields: *\nComment: **")
    @GetMapping("/getAllStudentRecords")
    public List<StudentBean> getStudentRecord() {
        List<StudentBean> record = studentService.getBeans();
        return record;
    }

    @ApiOperation(value = "This api is used for get record by date parameter",
            notes = "Status: Completed \nRequired Fields: * \nOptional Fields: *\nComment: **")
    @GetMapping("/getStudentRecorddate")
    public List<StudentBean> getStudentRecord(Long date) {
        List<StudentBean> record = studentService.getBean(date);
        return record;
    }

    @ApiOperation(value = "This api is used for post record to mysql database",
            notes = "Status: Completed \nRequired Fields: * \nOptional Fields: *\nComment: **")
    @PostMapping("/addStudentRecord")
    public String addStudentRecord(@RequestBody StudentBean bean) {
        return studentService.save(bean);
    }

    @ApiOperation(value = "This api is used to delete a record from database!",
            notes = "Status: Completed \nRequired Fields: * \nOptional Fields: *\nComment: **")
    @DeleteMapping("/student/{studentId}")
    public void deletestudent(@PathVariable("studentId") Long studentId) {

        studentService.deleteStudent(studentId);
    }

    @ApiOperation(value = "This api is used to mark record as deleted!",
            notes = "Status: Completed \nRequired Fields: * \nOptional Fields: *\nComment: **")
    @DeleteMapping("/student/{studentId}/markForDeletion")
    public void markStudentAsDeleted(@PathVariable("studentId") Long studentId) {
        studentService.markStudentAsDeleted(studentId);

    }

    @ApiOperation(value = "This api is used for update existing  record ",
            notes = "Status: Completed \nRequired Fields: * \nOptional Fields: *\nComment: **")
    @PutMapping("/updatestudent/{studentId}")
    public void updatestudent(@PathVariable("studentId") Long studentId, @RequestBody StudentPojo pojo) {
        studentService.update(studentId, pojo);

    }

    @ApiOperation(value = "Used to fetch record Hash Map from database",
            notes = "Status: Completed \nRequired Fields: * \nOptional Fields: *\nComment: **")
    @GetMapping("/getDobStudentNameHashMap")
    public HashMap<Date, String> getNameAgeHashMap(){
        return studentService.getDobStudentNameHashMap();
    }

        }
