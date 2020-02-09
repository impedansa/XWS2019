package com.megatravel.agent.soap.communication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.megatravel.agent.model.Apartment;
import com.megatravel.agent.model.Reservation;
import com.megatravel.agent.soap.ConfirmReservationRequest;
import com.megatravel.agent.soap.ConfirmReservationResponse;
import com.megatravel.agent.soap.CreateApartmentRequest;
import com.megatravel.agent.soap.CreateApartmentResponse;
import com.megatravel.agent.soap.CreateReservationRequest;
import com.megatravel.agent.soap.CreateReservationResponse;

@Service
public class ApartmentServiceCommunication {

	private static final String URI = "http://localhost:8762/apartments-service/services";
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public boolean createApartment(Apartment apartment) {
		this.template = new WebServiceTemplate(this.marshaller);
		CreateApartmentRequest request = new CreateApartmentRequest();
		request.setUnit(Mapper.from(apartment));
		CreateApartmentResponse response = (CreateApartmentResponse) template.marshalSendAndReceive(URI, request);
		return response.isOkay();
	}
	
	public boolean createReservation(Reservation reservation) {
		this.template = new WebServiceTemplate(this.marshaller);
		CreateReservationRequest request = new CreateReservationRequest();
		request.setReservation(Mapper.from(reservation));
		CreateReservationResponse response = (CreateReservationResponse) template.marshalSendAndReceive(URI, request);
		return response.isOkay();
	}
	
	public boolean confirmReservation(Long id) {
		this.template = new WebServiceTemplate(this.marshaller);
		ConfirmReservationRequest request = new ConfirmReservationRequest();
		request.setReservation(id);
		ConfirmReservationResponse response = (ConfirmReservationResponse) template.marshalSendAndReceive(URI, request);
		return response.isOkay();
	}
	
}
