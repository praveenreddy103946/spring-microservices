package com.course.course_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/course-app")
public class CourseAppApplication {
	
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/run")
	public String runAddressAppication() {
		
		return "Code written in Course Appication and running at port "+port;
				
		
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseAppApplication.class, args);
	}

}
