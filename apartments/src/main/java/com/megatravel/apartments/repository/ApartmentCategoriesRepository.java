package com.megatravel.apartments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.apartments.model.ApartmentCategory;

@Repository
public interface ApartmentCategoriesRepository extends JpaRepository<ApartmentCategory, Long> {

}
