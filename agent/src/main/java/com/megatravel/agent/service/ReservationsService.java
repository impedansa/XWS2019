package com.megatravel.agent.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.agent.dto.ReservationDTO;
import com.megatravel.agent.model.Apartment;
import com.megatravel.agent.model.Reservation;
import com.megatravel.agent.repository.ReservationsRepository;
import com.megatravel.agent.soap.communication.ApartmentServiceCommunication;

@Service
public class ReservationsService {

	@Autowired
	private ReservationsRepository reservationsRepository;
	
	@Autowired
	private ApartmentsService apartmentsService;
	
	@Autowired
	private ApartmentServiceCommunication apartmentServiceCommunication;
	
	public Boolean apartmentIsFree(Apartment apartment, Pair<LocalDate, LocalDate> pair) {
		List<Reservation> reservations = apartment.getReservations();
		reservations.removeIf(reservation -> reservation.getStart().isAfter(pair.getFirst()) || reservation.getEnd().isBefore(pair.getFirst()));
		return reservations.isEmpty();
	}
	
	private Reservation getById(Long id) {
		Optional<Reservation> reservation = reservationsRepository.findById(id);
		if(reservation.isPresent()) {
			return reservation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public void removeReservation(Long id) {
		Reservation reservation = getById(id);
		if(reservation.getApartment().getCancelable()) {
			reservationsRepository.delete(reservation);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	public Reservation createReservation(ReservationDTO reservationDTO) {
		Apartment apartment = apartmentsService.getById(reservationDTO.getApartment().getId());
		if(apartmentIsFree(apartment, Pair.of(reservationDTO.getStart(), reservationDTO.getEnd()))) {
			Reservation reservation = new Reservation(reservationDTO);
			reservation.setPrice(apartment.getPrice() * ChronoUnit.DAYS.between(reservationDTO.getStart(), reservationDTO.getEnd()));
			reservation.setApartment(apartment);
			if(!apartmentServiceCommunication.createReservation(reservation)) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			return reservationsRepository.save(reservation);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}	
	}

	public Reservation confirmReservation(Long id) {
		Reservation reservation = getById(id);
		if(reservation.getEnd().isBefore(LocalDate.now())) {
			reservation.setRealised(true);
			if(!apartmentServiceCommunication.confirmReservation(id)) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			return reservationsRepository.save(reservation);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	public List<Reservation> getAll() {
		return reservationsRepository.findAll();
	}
	
}
