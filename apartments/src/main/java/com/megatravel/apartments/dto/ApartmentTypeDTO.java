package com.megatravel.apartments.dto;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.apartments.model.ApartmentType;

public class ApartmentTypeDTO {

	private Long id;
	private String name;
	private String description;
	
	public ApartmentTypeDTO() { }
	
	public ApartmentTypeDTO(ApartmentType apartmentType) {
		this.id = apartmentType.getId();
		this.name = apartmentType.getName();
		this.description = apartmentType.getDescription();
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
	
	public static List<ApartmentTypeDTO> transform(List<ApartmentType> apartmentTypes) {
		List<ApartmentTypeDTO> result = new ArrayList<ApartmentTypeDTO>();
		apartmentTypes.forEach(type -> result.add(new ApartmentTypeDTO(type)));
		return result ;
	}
}
