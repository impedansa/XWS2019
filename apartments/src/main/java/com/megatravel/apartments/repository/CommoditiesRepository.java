package com.megatravel.apartments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.apartments.model.Commodity;

@Repository
public interface CommoditiesRepository extends JpaRepository<Commodity, Long> {

}
