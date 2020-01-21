package com.megatravel.user.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.megatravel.user.dto.RegistrationDTO;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private UserState state;
	
	private LocalDate birthday;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String name;
	
	@Column(unique = true)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	public User() { }
	
	public User(RegistrationDTO registrationDTO) {
		super();
		this.id = registrationDTO.getId();
		this.state = UserState.ACTIVE;
		this.birthday = registrationDTO.getBirthday();
		this.email = registrationDTO.getEmail();
		this.password = registrationDTO.getPassword();
		this.name = registrationDTO.getName();
		this.phoneNumber = registrationDTO.getPhoneNumber();
		this.role = registrationDTO.getRole();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
