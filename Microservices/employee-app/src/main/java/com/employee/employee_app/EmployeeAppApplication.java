package com.employee.employee_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RequestMapping("/employee-app")
@RestController
public class EmployeeAppApplication {

	@Value("${server.port}")
	private Integer port;

//	@Value("${addressservice.base.url}")
//	private String addressServiceBaseUrl;

	// @Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient webClient;

	/*
	 * Here we can define the root URL for the rest template
	 */

	@GetMapping("/run/{input}")
	public String runAddressAppication(@PathVariable String input) {

		String response = null;

		try {
			
			// response = restTemplate.getForObject(addressServiceBaseUrl + "{input}", String.class, input);
			// response = callingRestTemplate(input);
			// response = CallingWebClient(input);
			
			
			
			

		} catch (Exception e) {
			response = e.getMessage();
		}

		return "Code Written in Employee Application and running at port " + port + "\n=================> " + response;

	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}

	private String CallingWebClient(String input) {
		return webClient.get().uri("/" + input).retrieve().bodyToMono(String.class).block();
	}

	private String callingRestTemplate(String input) {
		return restTemplate.getForObject("/{input}", String.class, input);
	}

	//	public EmployeeAppApplication(@Value("${addressservice.base.url}") String addressServiceBaseUrl,
	//	RestTemplateBuilder builder) {
	//
	//  System.out.println("URL is "+addressServiceBaseUrl);
	//  this.restTemplate = builder
	//		.rootUri(addressServiceBaseUrl)
	//		.build();
    //}

}
