package com.megatravel.apartments.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.megatravel.apartments.dto.ApartmentDTO;

@Entity
public class Apartment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Min(0)
	private Double price;
	
	@Min(0)
	private Integer capacity;
	
	@Column(length = 32, nullable = false)
	private String city;
	
	@Column(length = 32, nullable = false)
	private String address;
	
	@ManyToOne
	private ApartmentCategory category;
	
	@ManyToOne
	private ApartmentType type;
	
	@ManyToMany
	private List<Commodity> commodities = new ArrayList<Commodity>();
	
	@OneToMany(mappedBy = "apartment")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Apartment() { }
	
	public Apartment(ApartmentDTO apartmentDTO) {
		this.id = apartmentDTO.getId();
		this.price = apartmentDTO.getPrice();
		this.city = apartmentDTO.getCity();
		this.address = apartmentDTO.getAddress();
		this.capacity = apartmentDTO.getCapacity();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ApartmentCategory getCategory() {
		return category;
	}

	public void setCategory(ApartmentCategory category) {
		this.category = category;
	}

	public ApartmentType getType() {
		return type;
	}

	public void setType(ApartmentType type) {
		this.type = type;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	
}
