package com.chickentest.chickentestapp.service.serviceimpl;
 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chickentest.chickentestapp.dto.ChickenDTO;
import com.chickentest.chickentestapp.dto.EggDTO;
import com.chickentest.chickentestapp.model.Chicken;
import com.chickentest.chickentestapp.model.Egg;
import com.chickentest.chickentestapp.model.Farm;
import com.chickentest.chickentestapp.repository.ChickenRepository;
import com.chickentest.chickentestapp.repository.EggRepository;
import com.chickentest.chickentestapp.repository.FarmRepository;
import com.chickentest.chickentestapp.service.EggService;

@Service
public class EggServiceImpl implements EggService{
	
	@Autowired
	private EggRepository eggRepository;
	
	@Autowired
	private ChickenRepository chickenRepository;
	
	@Autowired
	private FarmRepository farmRepository;

    @RequestMapping(path = "/eggs", method = RequestMethod.GET)
    public List<Object> getData(){
    	return eggRepository
    			.findAll()
    			.stream()
    			.map(egg -> getEggData(egg))
    			.collect(Collectors.toList());
    }
    
    public EggDTO getEggData(Egg egg){
    	Egg currentEgg = eggRepository.findById(egg.getId()).get();
    	EggDTO eggDTO = new EggDTO();
    	
    	eggDTO.setId(currentEgg.getId());
    	eggDTO.setChickenId(currentEgg.getChicken().getId());
    	eggDTO.setCreationDate(currentEgg.getCreationDate());
    	
    	return eggDTO;
    }  
    
    @Override
	public EggDTO add(EggDTO eggDTO) {
    	Egg eggToAdd = new Egg();
    	EggDTO eggToAddDTO = new EggDTO();
    	Chicken currentChicken = chickenRepository.findById(eggDTO.getChickenId()).get();
    	
        // Map EGG
    	eggToAdd.setChicken(currentChicken);
    	eggToAdd.setCreationDate(eggDTO.getCreationDate());
    	eggRepository.save(eggToAdd);
    	
    	// Map CHICKEN
    	currentChicken.addEgg(eggToAdd);
    	chickenRepository.save(currentChicken);
    	
    	// Map EGG-DTO
    	eggToAddDTO.setId(eggToAdd.getId());
    	eggToAddDTO.setCreationDate(eggDTO.getCreationDate());
    	eggToAddDTO.setChickenId(eggDTO.getChickenId());
		
		return eggToAddDTO;
		
	}
 
	@Override
	public EggDTO addById(long chickenId) {
    	Chicken currentChicken = chickenRepository.findById(chickenId).get();
    	Egg eggToAdd = new Egg();
		EggDTO eggToAddDTO = new EggDTO();
		
		//currentChicken.addEgg(eggToAdd);
		
        // Map EGG
		eggToAdd.setChicken(currentChicken);
    	eggRepository.save(eggToAdd);
    	
    	// Map CHICKEN
    	currentChicken.addEgg(eggToAdd);
    	chickenRepository.save(currentChicken);
    	
    	// Map EGG-DTO
    	eggToAddDTO.setId(eggToAdd.getId());
    	eggToAddDTO.setCreationDate(eggToAdd.getCreationDate());
    	eggToAddDTO.setChickenId(eggToAdd.getChicken().getId());
    	
		return eggToAddDTO;
	}

	@Override
	public EggDTO delete(EggDTO eggDTO) {
		
		Egg currentEgg = eggRepository.findById(eggDTO.getId()).get();
        Chicken currentChicken = chickenRepository.findById(eggDTO.getChickenId()).get();
                
        currentChicken.deleteEgg(currentEgg);

        eggRepository.delete(currentEgg);
        chickenRepository.save(currentChicken);
		
		return eggDTO;
	}

	
	
	// BORRAR
	
	@Override
	public ChickenDTO born(EggDTO eggDTO) {
		
		//Elimino el Egg
		Egg currentEgg = eggRepository.findById(eggDTO.getId()).get();
        Chicken currentChicken = chickenRepository.findById(eggDTO.getChickenId()).get();
		Farm currentFarm = farmRepository.findById(currentChicken.getFarm().getId()).get();
                
        currentChicken.deleteEgg(currentEgg);

        eggRepository.delete(currentEgg);
        chickenRepository.save(currentChicken);
        
        
        // Creo la Chicken
        Chicken chickenToBorn = new Chicken();
		ChickenDTO chickenToBornDTO = new ChickenDTO();

		//int eggNumber = currentChicken.getEggsAmount() + 1;
		String chickenName =  "egg of " + currentChicken.getName();
		
		chickenToBorn.setName(chickenName);
		chickenToBorn.setFarm(currentFarm);
    	chickenRepository.save(chickenToBorn);
    	
    	currentFarm.addChicken(chickenToBorn);
    	farmRepository.save(currentFarm);
    	
    	chickenToBornDTO.setId(chickenToBorn.getId());
    	chickenToBornDTO.setJoinDate(chickenToBorn.getJoinDate());
    	chickenToBornDTO.setFarmId(chickenToBorn.getFarm().getId());
		
		return chickenToBornDTO;
	}
}
