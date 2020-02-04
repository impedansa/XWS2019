package com.megatravel.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.agent.model.ApartmentCategory;

@Repository
public interface ApartmentCategoriesRepository extends JpaRepository<ApartmentCategory, Long> {

}
