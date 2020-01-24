package com.megatravel.apartments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.apartments.model.Apartment;

@Repository
public interface ApartmentsRepository extends JpaRepository<Apartment, Long> {

}
