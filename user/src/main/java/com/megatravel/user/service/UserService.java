package com.megatravel.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.megatravel.user.dto.LoginDTO;
import com.megatravel.user.dto.RegistrationDTO;
import com.megatravel.user.model.User;
import com.megatravel.user.model.UserRole;
import com.megatravel.user.model.UserState;
import com.megatravel.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User login(LoginDTO loginDTO) {
		User user = findUserByEmail(loginDTO.getEmail());
		if(user.getPassword().equals(loginDTO.getPassword()) &&
				!user.getRole().equals(UserRole.AGENT) &&
				user.getState().equals(UserState.ACTIVE)) {
			return user;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	public User register(RegistrationDTO registrationDTO) {
		if(emailExists(registrationDTO.getEmail())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			return userRepository.save(new User(registrationDTO));
		}
	}
	
	public User changeActiveState(Long id, UserState state) {
		User user = findUserById(id);
		if(user.getState().equals(UserState.REMOVED)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			user.setState(state);
			return userRepository.save(user);
		}
	}
	
	public User addAgent(RegistrationDTO registrationDTO) {
		if(emailExists(registrationDTO.getEmail())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			User user = new User(registrationDTO);
			user.setRole(UserRole.AGENT);
			return userRepository.save(user);
		}
	}
	
	private boolean emailExists(String email) { return userRepository.findByEmail(email).isPresent(); }
	
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
