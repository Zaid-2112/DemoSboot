package com.student.demo.beans;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class StudentBean {

    public Long rollNo;
    public String studentName;
    public String fatherName;
    public Date dob;


}
