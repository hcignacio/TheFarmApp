package com.chickentest.chickentestapp.service;

import java.util.List;
 
import com.chickentest.chickentestapp.dto.FarmDTO;
import com.chickentest.chickentestapp.model.Farm;

public interface FarmService {
	
	public List<Object> getFarms();
	
	public FarmDTO getFarmData(Farm farm);

	public FarmDTO add(FarmDTO farmDTO);

	public FarmDTO delete(FarmDTO farmDTO);
}
 