package com.megatravel.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.agent.dto.ApartmentTypeDTO;
import com.megatravel.agent.service.ApartmentTypesService;

@RestController
@RequestMapping(value = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentTypesController {

	@Autowired
	private ApartmentTypesService apartmentTypesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApartmentTypeDTO>> getAll() {
		return new ResponseEntity<List<ApartmentTypeDTO>>(ApartmentTypeDTO.transform(apartmentTypesService.getAll()), HttpStatus.OK);
	}
	
}
