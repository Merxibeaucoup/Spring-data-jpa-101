package com.edgar.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.jpa.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
