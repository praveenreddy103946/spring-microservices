package com.address.address_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/address-app")
public class AddressAppApplication {

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/run/{input}")
	public String runAddressAppication(@PathVariable String input) {

		return "Code written in Address Appication and running at port " + port +" and input is "+input;

	}

	public static void main(String[] args) {
		SpringApplication.run(AddressAppApplication.class, args);
	}

}
