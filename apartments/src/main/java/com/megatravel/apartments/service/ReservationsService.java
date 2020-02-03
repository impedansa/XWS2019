package com.megatravel.apartments.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.apartments.dto.ReservationDTO;
import com.megatravel.apartments.interfaces.UserServiceInterface;
import com.megatravel.apartments.model.Apartment;
import com.megatravel.apartments.model.Reservation;
import com.megatravel.apartments.repository.ReservationsRepository;

@Service
public class ReservationsService {

	@Autowired
	private ReservationsRepository reservationsRepository;
	
	@Autowired
	private ApartmentsService apartmentsService;
	
	@Autowired
	private UserServiceInterface userServiceInterface;
	
	public Boolean apartmentIsFree(Apartment apartment, Pair<LocalDate, LocalDate> pair) {
		List<Reservation> reservations = apartment.getReservations();
		reservations.removeIf(reservation -> reservation.getStart().isAfter(pair.getFirst()) || reservation.getEnd().isBefore(pair.getFirst()));
		return reservations.isEmpty();
	}
	
	public List<Reservation> getReservationHistoryOfUser(Long userId) {
		if(userExists(userId)) {
			List<Reservation> reservations = reservationsRepository.findAllByUser(userId);
			reservations.removeIf(reservation -> reservation.getEnd().isBefore(LocalDate.now()));
			return reservations;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public List<Reservation> getActiveReservationsOfUser(Long userId) {
		if(userExists(userId)) {
			List<Reservation> reservations = reservationsRepository.findAllByUser(userId);
			reservations.removeIf(reservation -> !reservation.getEnd().isBefore(LocalDate.now()));
			return reservations;			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	
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
		if(userExists(reservationDTO.getUser())) {
			Apartment apartment = apartmentsService.getById(reservationDTO.getApartment().getId());
			if(apartmentIsFree(apartment, Pair.of(reservationDTO.getStart(), reservationDTO.getEnd()))) {
				Reservation reservation = new Reservation(reservationDTO);
				reservation.setPrice(apartment.getPrice() * ChronoUnit.DAYS.between(reservationDTO.getStart(), reservationDTO.getEnd()));
				reservation.setApartment(apartment);
				return reservationsRepository.save(reservation);
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}	
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	private Boolean userExists(Long userId) {
		return userServiceInterface.getUser(userId).getStatusCode().is2xxSuccessful();
	}
}
