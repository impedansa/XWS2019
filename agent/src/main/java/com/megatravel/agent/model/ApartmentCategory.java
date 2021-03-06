package com.megatravel.agent.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ApartmentCategory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 32, nullable = false)
	private String name;
	
	@Column(unique = false, length = 512)
	private String description;
	
	@OneToMany(mappedBy = "category")
	private List<Apartment> apartments = new ArrayList<Apartment>();
	
	public ApartmentCategory() { }

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

	public List<Apartment> getApartments() {
		return apartments;
	}
}
