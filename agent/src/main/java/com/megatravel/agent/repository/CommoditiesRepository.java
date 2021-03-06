package com.megatravel.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.agent.model.Commodity;

@Repository
public interface CommoditiesRepository extends JpaRepository<Commodity, Long> {

}
