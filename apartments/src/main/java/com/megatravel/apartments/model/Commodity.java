package com.megatravel.apartments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.megatravel.apartments.dto.CommodityDTO;

@Entity
public class Commodity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 32, nullable = false)
	private String name;
	
	@Column(unique = false, length = 512)
	private String description;
	
	public Commodity() { }
	
	public Commodity(CommodityDTO commodityDTO) {
		this.id = commodityDTO.getId();
		this.name = commodityDTO.getName();
		this.description = commodityDTO.getDescription();
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

	public Commodity copyFrom(CommodityDTO commodityDTO) {
		this.name = commodityDTO.getName();
		this.description = commodityDTO.getDescription();
		return this;
	}
	
}
