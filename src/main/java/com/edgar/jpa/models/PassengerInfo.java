package com.edgar.jpa.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PASSENGER_INFO")
public class PassengerInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String passengerName;
	
	private String passengerEmail;
	
	private String source;
	
	private String Destination;
	
	private LocalDate travelDate;
	
	private LocalTime pickUpTime;
	
	private LocalTime arriveTime;
	
	private Double fare;

}
