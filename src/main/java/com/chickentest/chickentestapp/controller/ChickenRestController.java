package com.chickentest.chickentestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.service.ChickenService;

@RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.service"})
public class ChickenRestController {

    @Autowired
    private ChickenService chickenService;
    
    @RequestMapping(path = "/chickens", method = RequestMethod.GET)
    public List<Object> getChickens(){
    	return chickenService.getData();
    }
    
    @RequestMapping(path ="/add_chicken", method = RequestMethod.POST)
    public ChickenDTO addChicken(@RequestBody ChickenDTO chickenDTO){
    	ChickenDTO chickenDTOAdded = chickenService.add(chickenDTO);
    	return chickenDTOAdded;
    }
}
