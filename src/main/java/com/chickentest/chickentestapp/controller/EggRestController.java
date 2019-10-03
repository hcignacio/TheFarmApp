package com.chickentest.chickentestapp.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chickentest.chickentestapp.dto.ChickenDTO;
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
    	EggDTO eggToAddDTO = eggService.add(eggDTO);
    	return eggToAddDTO;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/add_egg_by_id", method = RequestMethod.POST)
    public EggDTO addEggById(@RequestBody long chickenId){
    	EggDTO eggToAddDTO = eggService.addById(chickenId);
    	return eggToAddDTO;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/del_egg", method = RequestMethod.POST)
    public EggDTO deleteEgg(@RequestBody EggDTO eggDTO){
    	EggDTO eggToDeleteDTO = eggService.delete(eggDTO);
    	return eggToDeleteDTO;
    }
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/born", method = RequestMethod.POST)
    public ChickenDTO bornEgg(@RequestBody EggDTO eggDTO){
    	ChickenDTO chickenToBornDTO = eggService.born(eggDTO);
    	return chickenToBornDTO;
    }
}
