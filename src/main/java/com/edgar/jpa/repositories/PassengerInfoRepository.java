package com.edgar.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.jpa.models.PassengerInfo;

@Repository
public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
