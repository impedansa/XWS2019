package com.megatravel.apartments.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.megatravel.apartments.model.Apartment;
import com.megatravel.apartments.model.Reservation;
import com.megatravel.apartments.repository.ReservationsRepository;

@Service
public class ReservationsService {

	@Autowired
	private ReservationsRepository reservationsRepository;
	
	public Boolean apartmentIsFree(Apartment apartment, Pair<LocalDate, LocalDate> pair) {
		List<Reservation> reservations = apartment.getReservations();
		reservations.removeIf(reservation -> reservation.getStart().isAfter(pair.getFirst()) || reservation.getEnd().isBefore(pair.getFirst()));
		return reservations.isEmpty();
	}
	
	public List<Reservation> getReservationsOfUser(Long user) {
		return reservationsRepository.findAllByUser(user);
	}
	
}
