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
import com.chickentest.chickentestapp.dto.EggDTO;
import com.chickentest.chickentestapp.service.ChickenService;

@RestController
@RequestMapping("/api")
@ComponentScan({"com.chickentest.chickentestapp.service"})
public class ChickenRestController {

    @Autowired
    private ChickenService chickenService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/chickens", method = RequestMethod.GET)
    public List<Object> getChickens(){
    	return chickenService.getChickens();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="{farm_id}/edit_chicken/{chicken_id}", method = RequestMethod.POST)
    public ChickenDTO editChicken(@PathVariable ("farm_id") long farm_id, @PathVariable ("chicken_id") long chicken_id, @RequestBody ChickenDTO chickenDTO){
    	ChickenDTO chickenToEditDTO = chickenService.edit(farm_id, chicken_id, chickenDTO);
    	return chickenToEditDTO;
    }
 
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/add_chicken", method = RequestMethod.POST)
    public ChickenDTO addChicken(@RequestBody ChickenDTO chickenDTO){
    	ChickenDTO chickenToAddDTO = chickenService.add(chickenDTO);
    	return chickenToAddDTO;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/add_chicken_by_id", method = RequestMethod.POST)
    public ChickenDTO addChickenById(@RequestBody long farmId){
    	ChickenDTO chickenDTOAdded = chickenService.addById(farmId);
    	return chickenDTOAdded;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path ="/del_chicken", method = RequestMethod.POST)
    public ChickenDTO deleteChicken(@RequestBody ChickenDTO chickenDTO){
    	ChickenDTO chickenToDeleteDTO = chickenService.delete(chickenDTO);
    	return chickenToDeleteDTO;
    }
}
