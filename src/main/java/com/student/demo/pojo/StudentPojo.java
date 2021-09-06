package com.student.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "student")
public class StudentPojo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE;

    @Column(name="roll_no")
    private Long rollNo;

    @Column(name = "father_name", nullable = true)
    private String fatherName;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "dob")
    private Date dob;

    @OneToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "college_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    private College college;

}