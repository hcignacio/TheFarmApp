package com.chickentest.chickentestapp.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.model.Chicken;
import com.chickentest.chickentestapp.model.Farm;
import com.chickentest.chickentestapp.repository.ChickenRepository;
import com.chickentest.chickentestapp.repository.EggRepository;
import com.chickentest.chickentestapp.repository.FarmRepository;
import com.chickentest.chickentestapp.service.ChickenService;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
    private ChickenRepository chickenRepository;
	
    @Autowired
    private FarmRepository farmRepository;
    
    @Autowired
    private EggRepository eggRepository;

    @Override
    public List<Object> getChickens(){
    	return chickenRepository
    			.findAll()
    			.stream()
    			.map(chicken -> getChickenData(chicken))
    			.collect(Collectors.toList());
    }
    
    @Override
    public ChickenDTO getChickenData(Chicken chicken){
    	Chicken currentChicken = chickenRepository.findById(chicken.getId()).get();
    	ChickenDTO chickenDTO = new ChickenDTO();
    	
    	chickenDTO.setId(currentChicken.getId());
    	chickenDTO.setFarmId(currentChicken.getFarm().getId());
    	chickenDTO.setJoinDate(currentChicken.getJoinDate());
    	chickenDTO.setName(currentChicken.getName());
    	
    	return chickenDTO;
    }
    
	@Override
	public ChickenDTO edit(ChickenDTO chickenDTO) {
		
		Chicken chickenToEdit = chickenRepository.findById(chickenDTO.getId()).get();
    	ChickenDTO chickenDTOEdited = new ChickenDTO();
        Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
            	
        /*
        // Map CHICKEN
        chickenAdded.setFarm(currentFarm);
    	chickenAdded.setJoinDate(chickenDTO.getJoinDate());
    	chickenAdded.setName(chickenDTO.getName());
    	chickenAdded.setInFarm(chickenDTO.getInFarm());
    	chickenRepository.save(chickenAdded);
    	
    	// Map FARM
    	currentFarm.addChicken(chickenAdded);
    	farmRepository.save(currentFarm);
    	
    	// Map CHICKEN-DTO
    	chickenDTOAdded.setId(chickenAdded.getId());
    	chickenDTOAdded.setJoinDate(chickenDTO.getJoinDate());
    	chickenDTOAdded.setName(chickenDTO.getName());
    	chickenDTOAdded.setFarmId(chickenDTO.getFarmId());
    	chickenDTOAdded.setInFarm(chickenDTO.getInFarm());
    	*/
		
		return chickenDTOEdited;
	}
    
	@Override
	public ChickenDTO add(ChickenDTO chickenDTO) {
    	Chicken chickenAdded = new Chicken();
    	ChickenDTO chickenDTOAdded = new ChickenDTO();
        Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
    	
        // Map CHICKEN
        chickenAdded.setFarm(currentFarm);
    	chickenAdded.setJoinDate(chickenDTO.getJoinDate());
    	chickenAdded.setName(chickenDTO.getName());
    	chickenAdded.setInFarm(chickenDTO.getInFarm());
    	chickenRepository.save(chickenAdded);
    	
    	// Map FARM
    	currentFarm.addChicken(chickenAdded);
    	farmRepository.save(currentFarm);
    	
    	// Map CHICKEN-DTO
    	chickenDTOAdded.setId(chickenAdded.getId());
    	chickenDTOAdded.setJoinDate(chickenDTO.getJoinDate());
    	chickenDTOAdded.setName(chickenDTO.getName());
    	chickenDTOAdded.setFarmId(chickenDTO.getFarmId());
    	chickenDTOAdded.setInFarm(chickenDTO.getInFarm());
		
		return chickenDTOAdded;
		
	}

	@Override
	public ChickenDTO delete(ChickenDTO chickenDTO) {
        
        Chicken currentChicken = chickenRepository.findById(chickenDTO.getId()).get();
        Farm currentFarm = farmRepository.findById(chickenDTO.getFarmId()).get();
                
        currentChicken.setInFarm(false);
        currentFarm.deleteChicken(currentChicken);

        eggRepository.deleteAll(currentChicken.getEggs());
        chickenRepository.delete(currentChicken);
        farmRepository.save(currentFarm);
        
		return chickenDTO;
	}	
}
