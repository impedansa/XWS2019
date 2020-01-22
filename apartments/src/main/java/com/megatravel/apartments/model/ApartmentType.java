package com.megatravel.apartments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.megatravel.apartments.dto.ApartmentTypeDTO;

@Entity
public class ApartmentType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 32, nullable = false)
	private String name;
	
	@Column(unique = false, length = 512)
	private String description;
	
	public ApartmentType() { }
	
	public ApartmentType(ApartmentTypeDTO apartmentTypeDTO) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ApartmentType copyFrom(ApartmentTypeDTO apartmentTypeDTO) {
		this.name = apartmentTypeDTO.getName();
		this.description = apartmentTypeDTO.getDescription();
		return this;
	}
}
