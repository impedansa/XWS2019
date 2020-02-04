package com.megatravel.agent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.agent.model.ApartmentCategory;
import com.megatravel.agent.repository.ApartmentCategoriesRepository;

@Service
public class ApartmentCategoriesService {

	@Autowired
	private ApartmentCategoriesRepository apartmentCategoriesRepository;
	
	public List<ApartmentCategory> getAll() {
		return apartmentCategoriesRepository.findAll();
	}

	public ApartmentCategory getById(Long id) {
		Optional<ApartmentCategory> category = apartmentCategoriesRepository.findById(id);
		if(category.isPresent()) {
			return category.get();
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

}
