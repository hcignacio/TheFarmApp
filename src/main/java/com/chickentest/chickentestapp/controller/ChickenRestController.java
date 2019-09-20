package com.chickentest.chickentestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chickentest.chickentestapp.serviceimpl.ChickenServiceImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.serviceimpl"})
public class ChickenRestController {

    @Autowired
    private ChickenServiceImpl chickenServiceImpl;
    
    @RequestMapping(path = "/chickens", method = RequestMethod.GET)
    public List<Object> getChickens(){
    	return chickenServiceImpl.getData();
    }
}
