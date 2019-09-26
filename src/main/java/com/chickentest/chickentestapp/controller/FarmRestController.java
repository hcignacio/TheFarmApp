package com.chickentest.chickentestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chickentest.chickentestapp.service.FarmService;
@RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.service"})
public class FarmRestController {
    
    @Autowired
    private FarmService farmService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/farm", method = RequestMethod.GET)
    public List<Object> getFarm(){
    	return farmService.getFarms();
    }
}