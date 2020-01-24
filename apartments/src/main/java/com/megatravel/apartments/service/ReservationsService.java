package com.megatravel.apartments.service;

import org.springframework.stereotype.Service;

import com.megatravel.apartments.model.Apartment;

@Service
public class ReservationsService {

	public Boolean apartmentIsFree(Apartment apartment) {
		return true;
	}
	
}
