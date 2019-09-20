package com.chickentest.chickentestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chickentest.chickentestapp.serviceimpl.FarmServiceImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.serviceimpl"})
public class FarmRestController {
    
    @Autowired
    private FarmServiceImpl farmServiceImpl;
    
    @RequestMapping(path = "/farm", method = RequestMethod.GET)
    public List<Object> getFarm(){
    	return farmServiceImpl.getData();
    }
}