package com.megatravel.agent.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.agent.dto.MessageDTO;
import com.megatravel.agent.dto.UserDTO;
import com.megatravel.agent.model.Message;
import com.megatravel.agent.repository.MessagesRepository;

@Service
public class MessagesService {

	@Autowired
	private MessagesRepository messagesRepository;

	@Autowired
	private UserService userService;
	
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
			sent.forEach(message -> counterparties.add(message.getRecipient().getId()));
			received.forEach(message -> counterparties.add(message.getSender().getId()));
			List<UserDTO> result = new ArrayList<UserDTO>();
			counterparties.forEach(user -> result.add(new UserDTO(userService.findUserById(user))));
			return result;
		}
	}
	
	private Boolean userExists(Long userId) {
		return userService.findUserById(userId) != null;
	}
	
	private Boolean userCanSendMessages(Long userId) {
		return true;
	}
}
