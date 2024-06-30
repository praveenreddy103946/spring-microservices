package com.feign.FeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/feign-app")
public class FiegnClientApplication {
	
	
	@Autowired
	private AddressClient addressClient;
	
	@Value("${server.port}")
	private Integer port;


	public static void main(String[] args) {
		SpringApplication.run(FiegnClientApplication.class, args);
	}
	
	
	@GetMapping("/run/{input}")
	public String runFeignApplication(@PathVariable("input") String input) {

		String response = null;
		
		try {
			
			// response = restTemplate.getForObject(addressServiceBaseUrl + "{input}", String.class, input);
			// response = callingRestTemplate(input);
			// response = CallingWebClient(input);
			   response = addressClient.getAddressFromEmployee(input);

		} catch (Exception e) {
			response = e.getMessage();
		}

		return "Code Written in Employee Application and running at port " + port + "\n=================> " + response;

	}
	
	
	

}
