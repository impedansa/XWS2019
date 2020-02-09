package com.megatravel.agent.controller;

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

import com.megatravel.agent.dto.ReservationDTO;
import com.megatravel.agent.service.ReservationsService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationsController {

	@Autowired
	private ReservationsService reservationsService;
	
	@RequestMapping(value = "/reservations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
		return new ResponseEntity<ReservationDTO>(new ReservationDTO(reservationsService.createReservation(reservationDTO)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeReservation(@PathVariable("id") Long id) {
		reservationsService.removeReservation(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.POST)
	public ResponseEntity<ReservationDTO> confirmReservation(@PathVariable("id") Long id) {
		return new ResponseEntity<ReservationDTO>(new ReservationDTO(reservationsService.confirmReservation(id)), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationDTO>> getAllReservation() {
		return new ResponseEntity<List<ReservationDTO>>(ReservationDTO.transform(reservationsService.getAll()), HttpStatus.OK);
	}
}
