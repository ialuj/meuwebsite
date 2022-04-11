package br.com.builders.buildersclientsmngapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = { "*" })
public class HelloControllers {
	
	@GetMapping
	public String showWelcomeMessage() {
           return "Hello! Welcome to API";
	}

}
