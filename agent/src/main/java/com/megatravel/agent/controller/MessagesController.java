package com.megatravel.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.agent.dto.MessageDTO;
import com.megatravel.agent.dto.UserDTO;
import com.megatravel.agent.service.MessagesService;

@RestController
@RequestMapping(value = "/users/{self-id}/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessagesController {

	@Autowired
	private MessagesService messagesService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageDTO> addMessage(@RequestBody MessageDTO messageDTO) {
		return new ResponseEntity<MessageDTO>(new MessageDTO(messagesService.addMessage(messageDTO)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/with/{user-id}", method = RequestMethod.GET)
	public ResponseEntity<List<MessageDTO>> findMessagesWithUser(@PathVariable("self-id") Long selfId, @PathVariable("user-id") Long userId) {
		return new ResponseEntity<List<MessageDTO>>(MessageDTO.transform(messagesService.findMessagesBetween(selfId, userId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getInbox(@PathVariable("self-id") Long selfId) {
		return new ResponseEntity<List<UserDTO>>(messagesService.getInbox(selfId), HttpStatus.OK);
	}
}
