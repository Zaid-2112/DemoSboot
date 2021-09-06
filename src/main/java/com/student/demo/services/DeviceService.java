/*
package com.student.demo.services;


import com.student.demo.pojo.College;
import com.student.demo.pojo.Device;
import com.student.demo.pojo.Device_Detail;
import com.student.demo.repositries.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    public DeviceRepository deviceRepository;


    public String save(Device pojo) {
        //StudentPojo pojo = convertBeanToPojo(bean);
        deviceRepository.save(pojo);
        return "success";
    }

    */
/*public Device sdf(Device pojo){

        Device records= deviceRepository.findByDevice_detail(pojo.getDevice_detail());

        return records;
    }*//*


   */
/*public List<Device> device() {
    return deviceRepository.findAll();
}*//*


    public Device getDeviceName(String deviceName) {

        //College college = new College(collegeId);
        Device pojo = deviceRepository.findByDeviceName(deviceName);
        return pojo;
    }
}*/
