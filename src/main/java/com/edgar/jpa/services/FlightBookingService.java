package com.edgar.jpa.services;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edgar.jpa.dto.FlightBookingAcknowledgement;
import com.edgar.jpa.dto.FlightBookingRequest;
import com.edgar.jpa.models.PassengerInfo;
import com.edgar.jpa.models.PaymentInfo;
import com.edgar.jpa.repositories.PassengerInfoRepository;
import com.edgar.jpa.repositories.PaymentInforRepository;

import lombok.RequiredArgsConstructor;
import utils.PaymentUtils;

@Service
@RequiredArgsConstructor
public class FlightBookingService {
	
	private final PaymentInforRepository paymentInforRepository;
	
	private final PassengerInfoRepository passengerInfoRepository;
	
	
	
	//new flight book request
	@Transactional //(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookingRequest(FlightBookingRequest bookingRequest) {
		
		
		PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
		PassengerInfo passengerInfo = passengerInfoRepository.save(bookingRequest.getPassengerInfo());
		
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getId());
		paymentInfo.setAmount(passengerInfo.getFare());
		
		paymentInforRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);
		
		
	}

}
