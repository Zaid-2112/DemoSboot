/*
package com.student.demo.controllers;


import com.student.demo.pojo.College;
import com.student.demo.pojo.Device;
import com.student.demo.pojo.Device_Detail;
import com.student.demo.services.DeviceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/device")
@Api(description = "This api is used for device information")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @PostMapping("/addDeviceRecord")
    public String addDeviceRecord(@RequestBody Device pojo) {
        return deviceService.save(pojo);
    }

   */
/* @GetMapping("/getrecord")
    public Device sdf(Device pojo){

        return deviceService.sdf(pojo);
    }*//*


   @GetMapping("/getfnameStudent/{deviceName}")
    public Device getDeviceName(@PathVariable("deviceName") String deviceName){
        return deviceService.getDeviceName(deviceName);
    }
}



*/
