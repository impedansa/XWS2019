package com.megatravel.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.agent.model.ApartmentType;

@Repository
public interface ApartmentTypesRepository extends JpaRepository<ApartmentType, Long> {

}
