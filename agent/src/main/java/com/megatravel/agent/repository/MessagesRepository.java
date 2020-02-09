package com.megatravel.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.megatravel.agent.model.Message;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Long> {

	@Query("SELECT m FROM Message m WHERE sender_id = :senderId AND recipient_id = :recipientID ORDER BY time DESC")
	List<Message> findMessagesBetween(@Param("senderId") Long senderId, @Param("recipientID") Long recipientId);

	List<Message> findAllBySenderId(Long senderId);
	
	List<Message> findAllByRecipientId(Long recipientId);
}
