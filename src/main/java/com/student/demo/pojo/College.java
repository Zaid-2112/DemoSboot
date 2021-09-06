package com.student.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "college")
public class College {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="college_name")
    private String college_Name;

    @Column(name = "college_location")
    private String collegeLocation;

/*
    @OneToOne(mappedBy = "college")
    @JsonBackReference
    private StudentPojo studentPojo;
*/

}