package com.edgar.jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgar.jpa.models.PaymentInfo;

public interface PaymentInforRepository extends JpaRepository<PaymentInfo, UUID> {

}
