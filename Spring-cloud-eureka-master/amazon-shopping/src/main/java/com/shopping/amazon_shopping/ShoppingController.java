package com.shopping.amazon_shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/amazon-shopping")
public class ShoppingController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/payment/{price}")
	public String invokePaymentMethod(@PathVariable Integer price) {
		
		String Url="http://PAYMENT-SERVICE/payment-service/payment";
		System.out.println("URL is "+Url);
		
		return restTemplate.getForObject("http://PAYMENT-SERVICE/payment-service/payment/"+price,String.class);
		
	}

}
