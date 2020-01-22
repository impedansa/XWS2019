package com.megatravel.apartments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.apartments.dto.ApartmentTypeDTO;
import com.megatravel.apartments.model.ApartmentType;
import com.megatravel.apartments.repository.ApartmentTypesRepository;

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

	public void delete(Long id) {
		ApartmentType type = getById(id);
		if(canDelete(type)) {
			apartmentTypesRepository.delete(type);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	private Boolean canDelete(ApartmentType type) {
		return true;
	}

	public ApartmentType create(ApartmentTypeDTO apartmentTypeDTO) {
		return apartmentTypesRepository.save(new ApartmentType(apartmentTypeDTO));
	}

	public ApartmentType update(ApartmentTypeDTO apartmentTypeDTO) {
		return apartmentTypesRepository.save(getById(apartmentTypeDTO.getId()).copyFrom(apartmentTypeDTO));
	}
}
