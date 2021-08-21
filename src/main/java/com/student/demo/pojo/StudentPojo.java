package com.student.demo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
@Table(name="student")
public class StudentPojo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rollno", nullable = false)
    private Long rollNo;

    @Column(name = "studentname", nullable = false)
    private String studentName;

    @Column(name = "fathername", nullable = false)
    private String fatherName;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "dob", nullable = false)
    private Date dob;
}
