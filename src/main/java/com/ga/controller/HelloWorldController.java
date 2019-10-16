package com.ga.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, this is a Spotify Clone!!";
	}

}
