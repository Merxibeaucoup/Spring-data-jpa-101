package com.edgar.jpa.dto;

import com.edgar.jpa.models.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {

	private String status;
	private Double totalFare;
	private String invoiceNo;
	private PassengerInfo passengerInfo;
}
