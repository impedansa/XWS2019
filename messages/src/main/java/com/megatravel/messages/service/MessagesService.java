package com.megatravel.messages.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.messages.dto.MessageDTO;
import com.megatravel.messages.dto.UserDTO;
import com.megatravel.messages.interfaces.UserServiceInterface;
import com.megatravel.messages.model.Message;
import com.megatravel.messages.repository.MessagesRepository;

@Service
public class MessagesService {

	@Autowired
	private MessagesRepository messagesRepository;

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	public Message addMessage(MessageDTO messageDTO) {
		Long senderId = messageDTO.getSenderId();
		Long recipientId = messageDTO.getRecipientId();
		if(!userCanSendMessages(senderId) || !userCanSendMessages(recipientId)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			Message message = new Message(messageDTO);
			return messagesRepository.save(message);
		}
	}

	public List<Message> findMessagesBetween(Long selfId, Long userId) {
		if(!userExists(selfId) || !userExists(userId)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return messagesRepository.findMessagesBetween(selfId, userId);
		}
	}

	public List<UserDTO> getInbox(Long selfId) {
		if(!userExists(selfId)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			List<Message> sent = messagesRepository.findAllBySenderId(selfId);
			List<Message> received = messagesRepository.findAllByRecipientId(selfId);
			Set<Long> counterparties = new HashSet<>();
			sent.forEach(message -> counterparties.add(message.getRecipientId()));
			received.forEach(message -> counterparties.add(message.getSenderId()));
			List<UserDTO> result = new ArrayList<UserDTO>();
			counterparties.forEach(user -> result.add(userServiceInterface.getUser(user).getBody()));
			return result;
		}
	}
	
	private Boolean userExists(Long userId) {
		return userServiceInterface.getUser(userId).getStatusCode().is2xxSuccessful();
	}
	
	private Boolean userCanSendMessages(Long userId) {
		return true;
	}
}
