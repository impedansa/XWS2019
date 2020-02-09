package com.megatravel.user.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.user.service.UserService;

@Endpoint
public class LoginEndpoint {

	private static final String NAMESPACE_URI = "http://www.megatravel.com/user/soap";
	
	@Autowired
	private UserService userService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "agentLoginRequest")
	@ResponsePayload
	public AgentLoginResponse logovanjeAgenta(@RequestPayload AgentLoginRequest request) {
		AgentLoginResponse response = new AgentLoginResponse();
		response.setOkay(userService.findUserByEmail(request.getEmail()).getPassword().equals(request.getPassword()));
		return response;
	}
	
}
