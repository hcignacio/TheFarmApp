package com.chickentest.chickentestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chickentest.chickentestapp.dto.EggDTO;
import com.chickentest.chickentestapp.service.EggService;

@RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.service"})
public class EggRestController {

    @Autowired
    private EggService eggService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/eggs", method = RequestMethod.GET)
    public List<Object> getEggs(){
    	return eggService.getData();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/add_egg", method = RequestMethod.POST)
    public EggDTO addEgg(@RequestBody EggDTO eggDTO){
    	EggDTO eggDTOAdded = eggService.add(eggDTO);
    	return eggDTOAdded;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/add_egg_by_id", method = RequestMethod.POST)
    public EggDTO addEggById(@RequestBody long chickenId){
    	EggDTO eggDTOAdded = eggService.addById(chickenId);
    	return eggDTOAdded;
    }
}
