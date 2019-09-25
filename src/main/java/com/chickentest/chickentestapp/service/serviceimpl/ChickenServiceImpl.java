package com.chickentest.chickentestapp.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.model.Chicken;
import com.chickentest.chickentestapp.repository.ChickenRepository;
import com.chickentest.chickentestapp.service.ChickenService;

@Service
public class ChickenServiceImpl implements ChickenService {

    @Autowired
    private ChickenRepository chickenRepository;

    @Override
    public List<Object> getData(){
    	return chickenRepository
    			.findAll()
    			.stream()
    			.map(chicken -> getChickenData(chicken))
    			.collect(Collectors.toList());
    }
    
    @Override
    public Chicken getChickenData(Chicken chicken){
    	Chicken currentChicken = chickenRepository.findById(chicken.getId()).get();
    	return currentChicken;
    }
    
    /*
    @Override
    public void addChicken(Chicken chicken) {
    	Map<String, Object> message = new LinkedHashMap<>();
        
    	
        if (!(farmRepository.findById(farm_id).isPresent())) {
            message.put("error", "ERROR: that farm does not exist");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        
        
        Farm currentFarm = farmRepository.findById(farm_id).get();
        
        
        Chicken chickenToAdd = new Chicken(currentFarm, chicken.getName());
        chickenRepository.save(chickenToAdd);
        
        currentFarm.addChicken(chickenToAdd);
        farmRepository.save(currentFarm);
        
        
        message.put("OK", "Chicken added");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    	
    }
	*/
    
	@Override
	public void addChicken(Chicken chicken) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteChicken(Chicken chicken) {
		// TODO Auto-generated method stub
		
	}


	
}
