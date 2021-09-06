package com.student.demo.repositries;

import com.student.demo.pojo.College;
import com.student.demo.pojo.StudentPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeviceRepository extends JpaRepository<College, Long> {


   // List<Device> findById(Long Long);

   // Device findByDevice_detail( Device_Detail device_detail);

//    Optional<Device> findByName(String name);


    //Device findByDeviceName(String deviceName);*/

}
