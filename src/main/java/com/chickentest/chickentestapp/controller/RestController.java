package com.chickentest.chickentestapp.controller;

/*
import com.chickentest.chickentestapp.model.*;
import com.chickentest.chickentestapp.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
*/
/*
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
*/
public class RestController {
	/*
    @Autowired
    private FarmRepository farmRepository;
    
    @Autowired
    private ChickenRepository chickenRepository;
    
    @Autowired
    private EggRepository eggRepository;
    
    @RequestMapping("/farm")
    public List<Object> getFarm(){
    	return (farmRepository
    			.findAll())
    			.stream()
    			.map(farm -> farmDTO(farm))
    			.collect(Collectors.toList());
    }
    
    public Map<String, Object> farmDTO(Farm farm){
    	Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", farm.getId());
        dto.put("chickensAmount", farm.getChickensAmount());
        dto.put("eggsAmountTotal", farm.getEggsAmountTotal());
        dto.put("chickens", farm.getChickens().stream().map(chicken -> chickenDTO(chicken)));
        dto.put("eggs", farm.getChickens().stream().map(chicken -> chicken.getEggs().stream().map(egg -> eggDTO(egg))));
   
    	return dto;
    }
    @RequestMapping("/chickens")
    public List<Object> getChickens(){
    	return (chickenRepository
    			.findAll())
    			.stream()
    			.map(chicken -> chickenDTO(chicken))
    			.collect(Collectors.toList());
    }
    
    public Map<String, Object> chickenDTO(Chicken chicken){
    	Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", chicken.getId());
        dto.put("farmId", chicken.getFarm().getId());
        dto.put("eggsAmount", chicken.getEggsAmount());
   
    	return dto;
    }
    @RequestMapping("/eggs")
    public List<Object> getEggs(){
    	return (eggRepository
    			.findAll())
    			.stream()
    			.map(egg -> eggDTO(egg))
    			.collect(Collectors.toList());
    }
    
    public Map<String, Object> eggDTO(Egg egg){
    	Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", egg.getId());
        dto.put("chickenId", egg.getChicken().getId());
   
    	return dto;
    }  
    
    @RequestMapping(path ="/{farm_id}/add_chicken", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addChicken(@PathVariable("farm_id") long farm_id, @RequestBody Chicken chicken){
        Map<String, Object> message = new LinkedHashMap<>();
        
        if (!(farmRepository.findById(farm_id).isPresent())) {
            message.put("error", "ERROR: that farm does not exist");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        
        Farm currentFarm = farmRepository.findById(farm_id).get();
        
        Chicken chickenToAdd = new Chicken(currentFarm, chicken.getName());
        //Chicken chickenToAdd = chicken;
        chickenRepository.save(chickenToAdd);
        
        currentFarm.addChicken(chickenToAdd);
        farmRepository.save(currentFarm);
        
        
        message.put("OK", "Chicken added");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    
    @RequestMapping(path ="/{farm_id}/del_chicken", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> deleteChicken(@PathVariable("farm_id") long farm_id, @RequestBody Chicken chicken){
        Map<String, Object> message = new LinkedHashMap<>();
        
        if (!(chickenRepository.findById(chicken.getId()).isPresent())) {
            message.put("error", "ERROR: that chicken does not exist");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        if (!(farmRepository.findById(farm_id).isPresent())) {
            message.put("error", "ERROR: that farm does not exist");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }

        Chicken currentChicken = chickenRepository.findById(chicken.getId()).get();
        Farm currentFarm = farmRepository.findById(farm_id).get();
                
        currentChicken.setInFarm(false);
        currentFarm.deleteChicken(currentChicken);

        eggRepository.deleteAll(currentChicken.getEggs());
        chickenRepository.delete(currentChicken);
        farmRepository.save(currentFarm);
        
        message.put("OK", "Chicken deleted");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    
    @RequestMapping(path ="/{chicken_id}/add_egg", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addEgg(@PathVariable("chicken_id") long chicken_id, @RequestBody Egg egg){
        Map<String, Object> message = new LinkedHashMap<>();
      
        if (!(chickenRepository.findById(chicken_id).isPresent())) {
            message.put("error", "ERROR: that chicken does not exist");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        
        Chicken currentChicken = chickenRepository.findById(chicken_id).get();
        
        Egg eggToAdd = new Egg();
        //eggToAdd.setId(egg.getId());
        eggToAdd.setCreationDate(egg.getcreationDate());
        eggToAdd.setChicken(currentChicken);
        
        currentChicken.addEgg(eggToAdd);
        
        eggRepository.save(eggToAdd);
        chickenRepository.save(currentChicken);
        
        message.put("OK", "Egg added");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    */
}
