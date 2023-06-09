package com.edgar.jpa.models;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {

	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID paymentId;

	private String accountNo;

	private Double amount;

	private String cardType;

	private Long passengerId;

}
