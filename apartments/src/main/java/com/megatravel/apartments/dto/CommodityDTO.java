package com.megatravel.apartments.dto;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.apartments.model.Commodity;

public class CommodityDTO {
	
	private Long id;
	private String name;
	private String description;
	
	public CommodityDTO() { }
	
	public CommodityDTO(Commodity commodity) {
		this.id = commodity.getId();
		this.name = commodity.getName();
		this.description = commodity.getDescription();
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
	
	public static List<CommodityDTO> transform(List<Commodity> commodities) {
		List<CommodityDTO> result = new ArrayList<CommodityDTO>();
		commodities.forEach(commodity -> result.add(new CommodityDTO(commodity)));
		return result;
	}
}
