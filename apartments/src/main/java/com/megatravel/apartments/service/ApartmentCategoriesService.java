package com.megatravel.apartments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.apartments.dto.ApartmentCategoryDTO;
import com.megatravel.apartments.model.ApartmentCategory;
import com.megatravel.apartments.repository.ApartmentCategoriesRepository;

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
	
	public void delete(Long id) {
		ApartmentCategory category = getById(id);
		if(canDelete(category)) {
			apartmentCategoriesRepository.delete(category);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	private Boolean canDelete(ApartmentCategory category) {
		return true;
	}
	
	public ApartmentCategory create(ApartmentCategoryDTO apartmentCategoryDTO) {
		return apartmentCategoriesRepository.save(new ApartmentCategory(apartmentCategoryDTO));
	}
	
	public ApartmentCategory update(ApartmentCategoryDTO apartmentCategoryDTO) {
		return apartmentCategoriesRepository.save(getById(apartmentCategoryDTO.getId()).copyFrom(apartmentCategoryDTO));
	}
}
