package com.megatravel.apartments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.apartments.model.Reservation;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Long> {

	@Query("SELECT r FROM Reservation r WHERE user = :user")
	List<Reservation> findAllByUser(Long user);

}
