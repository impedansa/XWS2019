package com.megatravel.apartments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.apartments.dto.ApartmentCategoryDTO;
import com.megatravel.apartments.service.ApartmentCategoriesService;

@RestController
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentCategoriesController {

	@Autowired
	private ApartmentCategoriesService apartmentCategoriesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApartmentCategoryDTO>> getAll() {
		return new ResponseEntity<List<ApartmentCategoryDTO>>(ApartmentCategoryDTO.transform(apartmentCategoriesService.getAll()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ApartmentCategoryDTO> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<ApartmentCategoryDTO>(new ApartmentCategoryDTO(apartmentCategoriesService.getById(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApartmentCategoryDTO> update(@RequestBody ApartmentCategoryDTO apartmentCategoryDTO) {
		return new ResponseEntity<ApartmentCategoryDTO>(new ApartmentCategoryDTO(apartmentCategoriesService.update(apartmentCategoryDTO)), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApartmentCategoryDTO> create(@RequestBody ApartmentCategoryDTO apartmentCategoryDTO) {
		return new ResponseEntity<ApartmentCategoryDTO>(new ApartmentCategoryDTO(apartmentCategoriesService.create(apartmentCategoryDTO)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		apartmentCategoriesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
