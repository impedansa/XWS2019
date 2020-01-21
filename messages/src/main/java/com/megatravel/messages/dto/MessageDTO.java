package com.megatravel.messages.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.megatravel.messages.model.Message;

public class MessageDTO {

	private Long id;
	
	private Long senderId;
	
	private Long recipientId;
	
	private LocalDateTime time;
	
	private String text;
	
	public MessageDTO(Message message) {
		this.id = message.getId();
		this.senderId = message.getSenderId();
		this.recipientId = message.getRecipientId();
		this.time = message.getTime();
		this.text = message.getText();
	}

	public static List<MessageDTO> transform(List<Message> messages) {
		List<MessageDTO> result = new ArrayList<MessageDTO>();
		messages.forEach(message -> result.add(new MessageDTO(message)));
		return result ;
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
