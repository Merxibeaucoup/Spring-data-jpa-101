package com.edgar.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.jpa.dto.FlightBookingAcknowledgement;
import com.edgar.jpa.dto.FlightBookingRequest;
import com.edgar.jpa.services.FlightBookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
@EnableTransactionManagement
public class FlightBookingController {
	
	private final FlightBookingService bookingService;
	
	@PostMapping("/book")
	public ResponseEntity<FlightBookingAcknowledgement>  bookFLight(@RequestBody FlightBookingRequest bookingRequest) {
		return ResponseEntity.ok(bookingService.bookingRequest(bookingRequest));
	}

}
