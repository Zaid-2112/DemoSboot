/*
package com.student.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  */
/*  @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE;*//*


    @Column(name = "device_name", nullable = true)
    private String device_Name;

    @Column(name="model_no")
    private Long model_No;


    @OneToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    @JsonBackReference
    private Device_Detail device_detail;


    */
/*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "detail_id", referencedColumnName = "id")
    List<Device_Detail> device_detail;*//*




}*/
