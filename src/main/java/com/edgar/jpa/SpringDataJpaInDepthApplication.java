package com.edgar.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringDataJpaInDepthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaInDepthApplication.class, args);
	}

}
