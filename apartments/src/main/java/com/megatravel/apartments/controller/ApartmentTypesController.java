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

import com.megatravel.apartments.dto.ApartmentTypeDTO;
import com.megatravel.apartments.service.ApartmentTypesService;

@RestController
@RequestMapping(value = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentTypesController {

	@Autowired
	private ApartmentTypesService apartmentTypesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApartmentTypeDTO>> getAll() {
		return new ResponseEntity<List<ApartmentTypeDTO>>(ApartmentTypeDTO.transform(apartmentTypesService.getAll()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ApartmentTypeDTO> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<ApartmentTypeDTO>(new ApartmentTypeDTO(apartmentTypesService.getById(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApartmentTypeDTO> update(@RequestBody ApartmentTypeDTO apartmentTypeDTO) {
		return new ResponseEntity<ApartmentTypeDTO>(new ApartmentTypeDTO(apartmentTypesService.update(apartmentTypeDTO)), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApartmentTypeDTO> create(@RequestBody ApartmentTypeDTO apartmentTypeDTO) {
		return new ResponseEntity<ApartmentTypeDTO>(new ApartmentTypeDTO(apartmentTypesService.create(apartmentTypeDTO)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		apartmentTypesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
