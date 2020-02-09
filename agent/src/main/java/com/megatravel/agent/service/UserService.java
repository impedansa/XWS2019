package com.megatravel.agent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.agent.dto.LoginDTO;
import com.megatravel.agent.model.User;
import com.megatravel.agent.model.UserRole;
import com.megatravel.agent.model.UserState;
import com.megatravel.agent.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User login(LoginDTO loginDTO) {
		User user = findUserByEmail(loginDTO.getEmail());
		if(user.getPassword().equals(loginDTO.getPassword()) &&
				user.getRole().equals(UserRole.AGENT) &&
				user.getState().equals(UserState.ACTIVE)) {
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
