package com.example.springsecurityandhibernate.controllers;

import com.example.springsecurityandhibernate.repository.UserService;
import com.example.springsecurityandhibernate.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public String showRegistrationForm(@ModelAttribute("user") UserRegistrationDto registrationDto)
	{
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto)
	{
		userService.save(registrationDto);
		return "redirect:/login";
	}
}
