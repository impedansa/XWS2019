package com.megatravel.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.agent.dto.CommodityDTO;
import com.megatravel.agent.service.CommoditiesService;

@RestController
@RequestMapping(value = "/commodities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommoditiesController {

	@Autowired
	private CommoditiesService commoditiesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CommodityDTO>> getAll() {
		return new ResponseEntity<List<CommodityDTO>>(CommodityDTO.transform(commoditiesService.getAll()), HttpStatus.OK);
	}

}
