package com.megatravel.agent.dto;

import java.time.LocalDate;

public class ApartmentsSearchDTO {

	private String city;
	private Integer capacity;
	private LocalDate start;
	private LocalDate end;
	
	public ApartmentsSearchDTO() { }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
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
	
}
