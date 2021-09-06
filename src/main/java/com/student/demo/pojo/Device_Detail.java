/*
package com.student.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "device_detail")
public class Device_Detail {

    @Id
    @Column(name = "detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detail_Id;

    @Column(name="brand")
    private String brand;

    @Column(name = "made_in")
    private String madein;

    @OneToOne(mappedBy = "device_detail")
    @JsonBackReference
    private Device Device;
}
*/
