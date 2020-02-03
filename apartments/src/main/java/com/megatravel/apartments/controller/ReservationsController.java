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

import com.megatravel.apartments.dto.ReservationDTO;
import com.megatravel.apartments.service.ReservationsService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationsController {

	@Autowired
	private ReservationsService reservationsService;
	
	@RequestMapping(value = "/users/{user-id}/history")
	public ResponseEntity<List<ReservationDTO>> getReservationHistoryOfUser(@PathVariable("user-id") Long userId) {
		return new ResponseEntity<List<ReservationDTO>>(ReservationDTO.transform(reservationsService.getReservationHistoryOfUser(userId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{user-id}/active")
	public ResponseEntity<List<ReservationDTO>> getActiveReservationsOfUser(@PathVariable("user-id") Long userId) {
		return new ResponseEntity<List<ReservationDTO>>(ReservationDTO.transform(reservationsService.getActiveReservationsOfUser(userId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reservations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationDTO> createReservationForUser(@RequestBody ReservationDTO reservationDTO) {
		return new ResponseEntity<ReservationDTO>(new ReservationDTO(reservationsService.createReservation(reservationDTO)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removeReservation(@PathVariable("id") Long id) {
		reservationsService.removeReservation(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
