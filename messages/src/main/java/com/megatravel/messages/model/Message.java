package com.megatravel.messages.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.megatravel.messages.dto.MessageDTO;

@Entity
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long senderId;
	
	private Long recipientId;
	
	private LocalDateTime time;
	
	@Column(length = 512)
	private String text;
	
	public Message() { }

	public Message(MessageDTO messageDTO) {
		this.id = messageDTO.getId();
		this.senderId = messageDTO.getSenderId();
		this.recipientId = messageDTO.getRecipientId();
		this.time = messageDTO.getTime();
		this.text = messageDTO.getText();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
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
