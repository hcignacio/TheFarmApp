package com.chickentest.chickentestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chickentest.chickentestapp.service.FarmService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.service"})
public class FarmRestController {
    
    @Autowired
    private FarmService farmService;
    
    @RequestMapping(path = "/farm", method = RequestMethod.GET)
    public List<Object> getFarm(){
    	return farmService.getData();
    }
}