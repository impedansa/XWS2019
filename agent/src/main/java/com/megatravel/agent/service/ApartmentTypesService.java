package com.megatravel.agent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.agent.model.ApartmentType;
import com.megatravel.agent.repository.ApartmentTypesRepository;

@Service
public class ApartmentTypesService {

	@Autowired
	private ApartmentTypesRepository apartmentTypesRepository;

	public List<ApartmentType> getAll() {
		return apartmentTypesRepository.findAll();
	}

	public ApartmentType getById(Long id) {
		Optional<ApartmentType> type = apartmentTypesRepository.findById(id);
		if(type.isPresent()) {
			return type.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
