package com.payment.payment_service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {
	
	
	@GetMapping("/payment/{price}")
	@CrossOrigin
	public String dummyMethod(@PathVariable Integer price) {
		return "payment Done Amount = " + price;
		
	}

}
