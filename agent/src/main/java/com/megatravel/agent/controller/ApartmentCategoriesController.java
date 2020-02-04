package com.megatravel.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.agent.dto.ApartmentCategoryDTO;
import com.megatravel.agent.service.ApartmentCategoriesService;

@RestController
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentCategoriesController {

	@Autowired
	private ApartmentCategoriesService apartmentCategoriesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApartmentCategoryDTO>> getAll() {
		return new ResponseEntity<List<ApartmentCategoryDTO>>(ApartmentCategoryDTO.transform(apartmentCategoriesService.getAll()), HttpStatus.OK);
	}
	
}
