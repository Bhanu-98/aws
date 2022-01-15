package com.learn.aws.aws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

import com.amazonaws.Response;

@RestController
@RequestMapping("api/v1/ec2")
public class EC2Controller {
    
    @Autowired
    EC2Service ec2Service;

    @GetMapping("/")
    public ResponseEntity<Object> getInstanceDetails(){
        return new ResponseEntity<Object>(ec2Service.getInstanceDetails(), HttpStatus.OK);
    }   

    @PostMapping("/")
    public ResponseEntity<Object> addDisk(InstanceModel instance){
        return new ResponseEntity<Object>(ec2Service.createVolume(instance), HttpStatus.OK);
    }
    
    @PostMapping("/attachVolume")
    public ResponseEntity<Object> attachVolumeToDisk(@RequestBody InstanceModel instance){
        return new ResponseEntity<Object>(ec2Service.attachVolumeToDisk(instance), HttpStatus.OK);
    }

    @PostMapping("/detachVolume")
    public ResponseEntity<Object> detachVolumeToDisk(@RequestBody InstanceModel instance){
        return new ResponseEntity<Object>(ec2Service.detachVolumeFromDisk(instance), HttpStatus.OK);
    }
}
