package com.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String getUser() {
		return "Test User";
	}

	@GetMapping("/product")
	public String getProductMessage() {
		String productMessage = restTemplate.getForObject("http://localhost:8082/product/", String.class);
		return "User Service calling Product Service: " + productMessage;
	}
}
