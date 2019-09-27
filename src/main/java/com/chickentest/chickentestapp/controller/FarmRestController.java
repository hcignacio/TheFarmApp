package com.chickentest.chickentestapp.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.dto.FarmDTO;
import com.chickentest.chickentestapp.service.FarmService;
@RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.service"})
public class FarmRestController {
    
    @Autowired
    private FarmService farmService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/farms", method = RequestMethod.GET)
    public List<Object> getFarm(){
    	return farmService.getFarms();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="edit_farm/{farm_id}", method = RequestMethod.POST)
    public FarmDTO editFarm(@PathVariable ("farm_id") long farm_id, @RequestBody FarmDTO farmDTO){
    	FarmDTO farmToEditDTO = farmService.edit(farm_id, farmDTO);
    	return farmToEditDTO;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/add_farm", method = RequestMethod.POST)
    public FarmDTO addFarm(@RequestBody FarmDTO farmDTO){
    	FarmDTO farmToAddDTO = farmService.add(farmDTO);
    	return farmToAddDTO;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/del_farm", method = RequestMethod.POST)
    public FarmDTO deleteFarm(@RequestBody FarmDTO farmDTO){
    	FarmDTO farmToDeleteDTO = farmService.delete(farmDTO);
    	return farmToDeleteDTO;
    }
} 