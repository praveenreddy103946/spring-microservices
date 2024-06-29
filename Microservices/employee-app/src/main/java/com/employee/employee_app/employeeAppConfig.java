package com.employee.employee_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class employeeAppConfig {
	
	
	@Value("${addressservice.base.url}")
	private String addressServiceBaseUrl;

	
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
	@Bean
	public WebClient webClient() {
		return WebClient
				.builder()
				.baseUrl(addressServiceBaseUrl)
				.build();
	}

}
