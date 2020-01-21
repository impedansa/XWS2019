package com.megatravel.user.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.megatravel.user.model.User;
import com.megatravel.user.model.UserRole;
import com.megatravel.user.model.UserState;

public class UserDTO {

	private Long id;
	private UserState state;
	private LocalDate birthday;
	private String email;
	private String name;
	private String phoneNumber;
	private UserRole role;
	
	public UserDTO() { }
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.state = user.getState();
		this.birthday = user.getBirthday();
		this.email = user.getEmail();
		this.name = user.getName();
		this.phoneNumber = user.getPhoneNumber();
		this.role = user.getRole();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static List<UserDTO> transform(List<User> users) {
		List<UserDTO> result = new ArrayList<UserDTO>();
		users.forEach(user -> result.add(new UserDTO(user)));
		return result;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
}
