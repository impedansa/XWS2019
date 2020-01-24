package com.megatravel.apartments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.apartments.dto.ApartmentDTO;
import com.megatravel.apartments.dto.ApartmentsSearchDTO;
import com.megatravel.apartments.service.ApartmentsService;

@RestController
@RequestMapping(value = "/apartments", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentsController {

	@Autowired
	private ApartmentsService apartmentsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApartmentDTO>> getAll() {
		return new ResponseEntity<List<ApartmentDTO>>(ApartmentDTO.transform(apartmentsService.getAll()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ApartmentDTO> getById(Long id) {
		return new ResponseEntity<ApartmentDTO>(new ApartmentDTO(apartmentsService.getById(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ApartmentDTO>> search(@RequestBody ApartmentsSearchDTO apartmentsSearchDTO) {
		return new ResponseEntity<List<ApartmentDTO>>(ApartmentDTO.transform(apartmentsService.search(apartmentsSearchDTO)), HttpStatus.OK);
	}
}
