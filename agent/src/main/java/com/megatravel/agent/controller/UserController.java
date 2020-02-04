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

import com.megatravel.agent.dto.LoginDTO;
import com.megatravel.agent.dto.UserDTO;
import com.megatravel.agent.service.UserService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {
		return new ResponseEntity<UserDTO>(new UserDTO(userService.login(loginDTO)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<List<UserDTO>> getUsers() {
		return new ResponseEntity<List<UserDTO>>(UserDTO.transform(userService.findAll()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<UserDTO>(new UserDTO(userService.findUserById(id)), HttpStatus.OK);
	}
}
