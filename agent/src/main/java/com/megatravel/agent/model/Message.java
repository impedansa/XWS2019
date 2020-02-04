package com.megatravel.agent.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.megatravel.agent.dto.MessageDTO;

@Entity
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User sender;

	@ManyToOne
	private User recipient;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime time;
	
	@Column(length = 512)
	private String text;
	
	public Message() { }

	public Message(MessageDTO messageDTO) {
		this.id = messageDTO.getId();
		this.time = messageDTO.getTime();
		this.text = messageDTO.getText();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
