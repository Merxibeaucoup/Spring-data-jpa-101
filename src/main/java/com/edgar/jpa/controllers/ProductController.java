package com.edgar.jpa.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.jpa.dto.APIResponse;
import com.edgar.jpa.models.Product;
import com.edgar.jpa.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public APIResponse<List<Product>> getProducts() {
		List<Product> allProducts = productService.findAllProducts();
		return new APIResponse<>(allProducts.size(), allProducts);

	}
	
	@GetMapping("/{field}")
	public APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
		List<Product> allProducts = productService.findProductsWithSorting(field);
		return new APIResponse<>(allProducts.size(), allProducts);

	}
	
	@GetMapping("/pagination/{offSet}/{pageSize}")
	public APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offSet, @PathVariable int pageSize) {
		Page<Product> paginatedProducts = productService.findProductsWithPagination(offSet, pageSize);
		return new APIResponse<>(paginatedProducts.getSize(), paginatedProducts);

	}
	
	@GetMapping("/paginationAndSort/{offSet}/{pageSize}/{field}")
	public APIResponse<Page<Product>> getProductsWithSortAndPagination(@PathVariable int offSet, @PathVariable int pageSize, @PathVariable String field) {
		Page<Product> paginatedProducts = productService.findProductsWithPaginationAndSorting(offSet, pageSize, field);
		return new APIResponse<>(paginatedProducts.getSize(), paginatedProducts);

	}
	
	@PatchMapping("/update/field/{id}")
	public ResponseEntity<Product> updateProductField(@PathVariable Long id, Map<String, Object> fields){
		return ResponseEntity.ok(productService.updateProductFields(id, fields));
	}

}
