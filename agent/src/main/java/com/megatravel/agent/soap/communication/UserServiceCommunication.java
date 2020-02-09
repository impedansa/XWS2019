package com.megatravel.agent.soap.communication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.megatravel.agent.soap.AgentLoginRequest;
import com.megatravel.agent.soap.AgentLoginResponse;

@Service
public class UserServiceCommunication {

	private static final String URI = "http://localhost:8762/user-service/services";
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public boolean loginAgent(String email, String password) {
		this.template = new WebServiceTemplate(this.marshaller);
		AgentLoginRequest request = new AgentLoginRequest();
		request.setEmail(email);
		request.setPassword(password);
		AgentLoginResponse response = (AgentLoginResponse) template.marshalSendAndReceive(URI, request);
		return response.isOkay();
	}
	
}