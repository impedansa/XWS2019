package com.megatravel.agent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.agent.dto.LoginDTO;
import com.megatravel.agent.model.User;
import com.megatravel.agent.repository.UserRepository;
import com.megatravel.agent.soap.communication.UserServiceCommunication;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceCommunication userServiceCommunication;
	
	public User login(LoginDTO loginDTO) {
		User user = findUserByEmail(loginDTO.getEmail());
		if(userServiceCommunication.loginAgent(loginDTO.getEmail(), loginDTO.getPassword())) {
			return user;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public User findUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			return user.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
}
