package com.megatravel.apartments.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.megatravel.apartments.dto.ReservationDTO;

@Entity
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Min(0)
	private Double price;
	
	@Column(nullable = false)
	private LocalDate start;
	
	@Column(nullable = false)
	private LocalDate end;
	
	@Column(nullable = false)
	private Long user;
	
	@ManyToOne
	private Apartment apartment;
	
	public Reservation() { }
	
	public Reservation(ReservationDTO reservationDTO) {
		this.id = reservationDTO.getId();
		this.start = reservationDTO.getStart();
		this.end = reservationDTO.getEnd();
		this.user = reservationDTO.getUser();
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

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
}
