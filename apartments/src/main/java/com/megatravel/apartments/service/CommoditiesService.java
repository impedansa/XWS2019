package com.megatravel.apartments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.apartments.dto.CommodityDTO;
import com.megatravel.apartments.model.Commodity;
import com.megatravel.apartments.repository.CommoditiesRepository;

@Service
public class CommoditiesService {

	@Autowired
	private CommoditiesRepository commoditiesRepository;
	
	public List<Commodity> getAll() {
		return commoditiesRepository.findAll();
	}
	
	public Commodity getById(Long id) {
		Optional<Commodity> commodity = commoditiesRepository.findById(id);
		if(commodity.isPresent()) {
			return commodity.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public void delete(Long id) {
		Commodity commodity = getById(id);
		if(canDelete(commodity)) {
			commoditiesRepository.delete(commodity);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	private boolean canDelete(Commodity commodity) {
		return true;
	}
	
	public Commodity update(CommodityDTO commodityDTO) {
		return commoditiesRepository.save(getById(commodityDTO.getId()).copyFrom(commodityDTO));
	}
	
	public Commodity create(CommodityDTO commodityDTO) {
		return commoditiesRepository.save(new Commodity(commodityDTO));
	}
}
