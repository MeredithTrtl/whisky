package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping
    public ResponseEntity getAllWhiskiesFilterByYear(@RequestParam(required = false, name = "year") Integer year){
        if (year != null){
            return new ResponseEntity(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries")
    public ResponseEntity getAllWhiskiesFilterByDistilleryAndAge(
            @RequestParam(required = false, name = "distilleryId") Long distilleryId,
            @RequestParam(required = false, name = "age") Integer age
    ){ if (distilleryId != null && age != null){
        return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryIdAndAge(distilleryId, age), HttpStatus.OK);
    }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/regions")
    public ResponseEntity getAllWhiskiesFilterByDistilleryRegion(@RequestParam(required = false, name = "region") String region){
        if (region != null){
            return new ResponseEntity(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }

}
