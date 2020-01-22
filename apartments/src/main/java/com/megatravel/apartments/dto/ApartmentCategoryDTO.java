package com.megatravel.apartments.dto;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.apartments.model.ApartmentCategory;

public class ApartmentCategoryDTO {

	private Long id;
	private String name;
	private String description;

	public ApartmentCategoryDTO() { }
	
	public ApartmentCategoryDTO(ApartmentCategory apartmentCategory) {
		this.id = apartmentCategory.getId();
		this.name = apartmentCategory.getName();
		this.description = apartmentCategory.getDescription();
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
	
	public static List<ApartmentCategoryDTO> transform(List<ApartmentCategory> apartmentCategories) {
		List<ApartmentCategoryDTO> result = new ArrayList<ApartmentCategoryDTO>();
		apartmentCategories.forEach(category -> result.add(new ApartmentCategoryDTO(category)));
		return result;
	}
	
}
