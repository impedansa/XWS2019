package com.megatravel.agent.soap.communication;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.agent.model.Apartment;
import com.megatravel.agent.model.ApartmentCategory;
import com.megatravel.agent.model.ApartmentType;
import com.megatravel.agent.model.Reservation;
import com.megatravel.agent.soap.ApartmentCategoryDTO;
import com.megatravel.agent.soap.ApartmentDTO;
import com.megatravel.agent.soap.ApartmentTypeDTO;
import com.megatravel.agent.soap.ReservationDTO;

public class Mapper {

	public static final ApartmentDTO from(Apartment apartment) {
		ApartmentDTO result = new ApartmentDTO();
		result.setCapacity(apartment.getCapacity());
		result.setPrice(apartment.getPrice());
		result.setCity(apartment.getCity());
		result.setAddress(apartment.getAddress());
		result.setCategory(from(apartment.getCategory()));
		result.setType(from(apartment.getType()));
		result.setCancelable(apartment.getCancelable());
		return result;
	}
	
	public static final ApartmentCategoryDTO from(ApartmentCategory category) {
		ApartmentCategoryDTO result = new ApartmentCategoryDTO();
		result.setId(category.getId());
		return result;
	}
	
	public static final ApartmentTypeDTO from(ApartmentType type) {
		ApartmentTypeDTO result = new ApartmentTypeDTO();
		result.setId(type.getId());
		return result ;
	}
	
	public static final ReservationDTO from(Reservation reservation) {
		ReservationDTO result = new ReservationDTO();
		ApartmentDTO apartment = new ApartmentDTO();
		apartment.setId(reservation.getApartment().getId());
		result.setApartment(apartment);
		try {
			result.setStart(DatatypeFactory.newInstance().newXMLGregorianCalendar(reservation.getStart().toString()));
			result.setEnd(DatatypeFactory.newInstance().newXMLGregorianCalendar(reservation.getEnd().toString()));
		} catch(DatatypeConfigurationException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
}
