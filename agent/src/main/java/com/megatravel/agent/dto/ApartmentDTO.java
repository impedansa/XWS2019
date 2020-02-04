package com.megatravel.agent.dto;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.agent.model.Apartment;

public class ApartmentDTO {

	private Long id;
	private Integer capacity;
	private Double price;
	private String city;
	private String address;
	private ApartmentCategoryDTO category;
	private ApartmentTypeDTO type;
	private Boolean cancelable;
	private List<CommodityDTO> commodities;

	public ApartmentDTO() { }
	
	public ApartmentDTO(Apartment apartment) {
		this.id = apartment.getId();
		this.capacity = apartment.getCapacity();
		this.price = apartment.getPrice();
		this.city = apartment.getCity();
		this.address = apartment.getAddress();
		this.category = new ApartmentCategoryDTO(apartment.getCategory());
		this.type = new ApartmentTypeDTO(apartment.getType());
		this.cancelable = apartment.getCancelable();
		this.commodities = CommodityDTO.transform(apartment.getCommodities());
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

	public ApartmentCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(ApartmentCategoryDTO category) {
		this.category = category;
	}

	public ApartmentTypeDTO getType() {
		return type;
	}

	public void setType(ApartmentTypeDTO type) {
		this.type = type;
	}

	public List<CommodityDTO> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<CommodityDTO> commodities) {
		this.commodities = commodities;
	}
	
	public static List<ApartmentDTO> transform(List<Apartment> apartments) {
		List<ApartmentDTO> result = new ArrayList<ApartmentDTO>();
		apartments.forEach(apartment -> result.add(new ApartmentDTO(apartment)));
		return result;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getCancelable() {
		return cancelable;
	}

	public void setCancelable(Boolean cancelable) {
		this.cancelable = cancelable;
	}
	
}
