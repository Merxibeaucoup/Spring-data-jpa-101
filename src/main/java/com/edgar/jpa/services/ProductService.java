package com.edgar.jpa.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.edgar.jpa.models.Product;
import com.edgar.jpa.repositories.ProductRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	
	//initialize data in DB -> 50 count
	@PostConstruct
	public void initDB() {
		List<Product> products = IntStream.rangeClosed(1,50)
				.mapToObj(i -> new Product("Product"+i, new Random().nextInt(100), new Random().nextLong(50000)))
				.collect(Collectors.toList());
		productRepository.saveAll(products);
	}
	
	// find all products 
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	//find sorted products by field 
	public List<Product> findProductsWithSorting(String field){
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	
	/*
	 * find products with pagination
	 * pageSize -> items per page
	 * offSet -> page number
	 * 
	 */
	public Page<Product> findProductsWithPagination(int offSet, int pageSize) {
		Page<Product> products = productRepository.findAll(PageRequest.of(offSet, pageSize));
		return products;

	}
	
	/*
	 * find products with pagination
	 * pageSize -> items per page
	 * offSet -> page number
	 * field -> sort by
	 */
	public Page<Product> findProductsWithPaginationAndSorting(int offSet, int pageSize, String field) {
		Page<Product> products = productRepository.findAll(PageRequest.of(offSet, pageSize).withSort(Sort.by(field)));
		
		return products;

	}
	
	

}
