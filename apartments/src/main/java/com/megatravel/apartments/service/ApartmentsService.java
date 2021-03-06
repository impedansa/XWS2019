package com.megatravel.apartments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.apartments.dto.ApartmentsSearchDTO;
import com.megatravel.apartments.model.Apartment;
import com.megatravel.apartments.repository.ApartmentsRepository;
import com.megatravel.apartments.soap.ApartmentDTO;

@Service
public class ApartmentsService {

	@Autowired
	private ApartmentsRepository apartmentsRepository;
	
	@Autowired
	private ReservationsService reservationsService;
	
	@Autowired
	private ApartmentTypesService apartmentTypesService;
	
	@Autowired
	private ApartmentCategoriesService apartmentCategoriesService;
	
	public List<Apartment> getAll() {
		return apartmentsRepository.findAll();
	}
	
	public Apartment getById(Long id) {
		Optional<Apartment> apartment = apartmentsRepository.findById(id);
		if(apartment.isPresent()) {
			return apartment.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public List<Apartment> search(ApartmentsSearchDTO apartmentsSearchDTO) {
		List<Apartment> result = getAll();
		result.removeIf(apartment -> !apartment.getCity().contains(apartmentsSearchDTO.getCity()));
		result.removeIf(apartment -> apartment.getCapacity() < apartmentsSearchDTO.getCapacity());
		result.removeIf(apartment -> !reservationsService.apartmentIsFree(apartment, Pair.of(apartmentsSearchDTO.getStart(), apartmentsSearchDTO.getEnd())));
		return result;
	}
	
	public Apartment createApartment(ApartmentDTO apartmentDTO) {
		Apartment apartment = new Apartment(apartmentDTO);
		apartment.setType(apartmentTypesService.getById(apartmentDTO.getType().getId()));
		apartment.setCategory(apartmentCategoriesService.getById(apartmentDTO.getCategory().getId()));
		return apartmentsRepository.save(apartment);
	}
	
}
