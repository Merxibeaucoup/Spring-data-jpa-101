package com.edgar.jpa.dto;

import com.edgar.jpa.models.PassengerInfo;
import com.edgar.jpa.models.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;

	private PaymentInfo paymentInfo;
}
