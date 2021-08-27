package com.student.demo.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "student")
public class StudentPojo {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE;

    @Column(name="roll_no")
    private Long rollno;

    @Column(name = "father_name", nullable = true)
    private String fathername;

    @Column(name = "student_name")
    private String studentname;

    @Column(name = "dob")
    private Date dob;

}