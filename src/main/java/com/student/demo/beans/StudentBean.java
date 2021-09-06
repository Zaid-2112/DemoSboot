package com.student.demo.beans;

import com.student.demo.pojo.College;
import com.student.demo.pojo.StudentPojo;
import lombok.Data;

@Data
public class StudentBean {

    public Long rollNo;
    public String studentName;
    public String fatherName;
    public Long dob;
    public College college;

}
