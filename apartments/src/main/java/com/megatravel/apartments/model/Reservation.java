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
	
	@Column(nullable = true)
	private Long user;
	
	@ManyToOne
	private Apartment apartment;
	
	@Column(nullable = false)
	private Boolean realised;
	
	public Reservation() { }
	
	public Reservation(ReservationDTO reservationDTO) {
		this.id = reservationDTO.getId();
		this.start = reservationDTO.getStart();
		this.end = reservationDTO.getEnd();
		this.user = reservationDTO.getUser();
		this.realised = false;
	}
	
	public Reservation(com.megatravel.apartments.soap.ReservationDTO reservationDTO) {
		this.id = reservationDTO.getId();
		this.start = LocalDate.of(
				reservationDTO.getStart().getYear(), 
				reservationDTO.getStart().getMonth(), 
				reservationDTO.getStart().getDay()
				);
		this.end = LocalDate.of(
				reservationDTO.getEnd().getYear(), 
				reservationDTO.getEnd().getMonth(), 
				reservationDTO.getEnd().getDay()
				);
		this.realised = false;	
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

	public Boolean getRealised() {
		return realised;
	}

	public void setRealised(Boolean realised) {
		this.realised = realised;
	}
}
