package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping
    public ResponseEntity getAllDistilleriesByRegion(@RequestParam(required = false, name = "region") String region){
        if (region != null){
            return new ResponseEntity(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value = "/twelve")
//    public ResponseEntity getAllDistilleriesWithWhiskiesOlderThan12(){
//        return new ResponseEntity(distilleryRepository.findDistilleryByWhiskyAgeGreaterThan12(), HttpStatus.OK);
//    }


}
