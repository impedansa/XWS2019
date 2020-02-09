package com.megatravel.apartments.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.apartments.service.ApartmentsService;
import com.megatravel.apartments.service.ReservationsService;

@Endpoint
public class ApartmentsEndpoint {

	private static final String NAMESPACE_URI = "http://www.megatravel.com/apartments/soap";
	
	@Autowired
	private ApartmentsService apartmentsService;
	
	@Autowired
	private ReservationsService reservationService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createApartmentRequest")
	@ResponsePayload
	public CreateApartmentResponse createApartment(@RequestPayload CreateApartmentRequest request) {
		CreateApartmentResponse response = new CreateApartmentResponse();
		response.setOkay(apartmentsService.createApartment(request.getUnit()) != null);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createReservationRequest")
	@ResponsePayload
	public CreateReservationResponse createReservation(@RequestPayload CreateReservationRequest request) {
		CreateReservationResponse response = new CreateReservationResponse();
		response.setOkay(reservationService.createAgentReservation(request.getReservation()) != null);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "confirmReservationRequest")
	public ConfirmReservationResponse confirmReservation(@RequestPayload ConfirmReservationRequest request) {
		ConfirmReservationResponse response = new ConfirmReservationResponse();
		response.setOkay(reservationService.confirmReservation(request.getReservation()) != null);
		return response ;
	}
	
}
