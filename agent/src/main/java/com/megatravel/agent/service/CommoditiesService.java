package com.megatravel.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.agent.model.Commodity;
import com.megatravel.agent.repository.CommoditiesRepository;

@Service
public class CommoditiesService {

	@Autowired
	private CommoditiesRepository commoditiesRepository;
	
	public List<Commodity> getAll() {
		return commoditiesRepository.findAll();
	}

}
