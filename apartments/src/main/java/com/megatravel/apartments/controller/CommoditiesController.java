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

import com.megatravel.apartments.dto.CommodityDTO;
import com.megatravel.apartments.service.CommoditiesService;

@RestController
@RequestMapping(value = "/commodities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommoditiesController {

	@Autowired
	private CommoditiesService commoditiesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CommodityDTO>> getAll() {
		return new ResponseEntity<List<CommodityDTO>>(CommodityDTO.transform(commoditiesService.getAll()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<CommodityDTO> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<CommodityDTO>(new CommodityDTO(commoditiesService.getById(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommodityDTO> update(@RequestBody CommodityDTO commodityDTO) {
		return new ResponseEntity<CommodityDTO>(new CommodityDTO(commoditiesService.update(commodityDTO)), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommodityDTO> create(@RequestBody CommodityDTO commodityDTO) {
		return new ResponseEntity<CommodityDTO>(new CommodityDTO(commoditiesService.create(commodityDTO)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		commoditiesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
