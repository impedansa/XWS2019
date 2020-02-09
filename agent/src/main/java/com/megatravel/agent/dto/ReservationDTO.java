package com.megatravel.agent.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.megatravel.agent.model.Reservation;

public class ReservationDTO {

	private Long id;
	private Double price;
	private LocalDate start;
	private LocalDate end;
	private Long user;
	private ApartmentDTO apartment;
	private Boolean realised;

	public ReservationDTO() { }
	
	public ReservationDTO(Reservation reservation) {
		this.id = reservation.getId();
		this.price = reservation.getPrice();
		this.start = reservation.getStart();
		this.end = reservation.getEnd();
		if(reservation.getUser() != null) this.user = reservation.getUser().getId();
		this.apartment = new ApartmentDTO(reservation.getApartment());
		this.realised = reservation.getRealised();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public ApartmentDTO getApartment() {
		return apartment;
	}

	public void setApartment(ApartmentDTO apartment) {
		this.apartment = apartment;
	}
	
	public static List<ReservationDTO> transform(List<Reservation> reservations) {
		List<ReservationDTO> result = new ArrayList<ReservationDTO>();
		reservations.forEach(reservation -> result.add(new ReservationDTO(reservation)));
		return result;
	}

	public Boolean getRealised() {
		return realised;
	}

	public void setRealised(Boolean realised) {
		this.realised = realised;
	}
	
}
