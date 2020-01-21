package com.megatravel.messages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.messages.model.Message;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Long> {

	@Query("SELECT * FROM message WHERE senderId = :senderId AND recipientID = :recipientID ORDER BY time DESC")
	List<Message> findMessagesBetween(Long senderId, Long recipientId);

	List<Message> findAllBySenderId(Long senderId);
	
	List<Message> findAllByRecipientId(Long recipientId);
}
