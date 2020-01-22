package com.megatravel.apartments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.apartments.model.ApartmentType;

@Repository
public interface ApartmentTypesRepository extends JpaRepository<ApartmentType, Long> {

}
