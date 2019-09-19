package com.chickentest.chickentestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chickentest.chickentestapp.service.ChickenService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.service"})
public class ChickenRestController {

    @Autowired
    private ChickenService chickenService;
    
    @RequestMapping(path = "/chickens", method = RequestMethod.GET)
    public List<Object> getChickens(){
    	return chickenService.getData();
    }
}
