package com.example.springsecurityandhibernate.controllers;

import com.example.springsecurityandhibernate.repository.UserService;
import com.example.springsecurityandhibernate.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private final UserService userService;

	@Autowired
	public MainController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping()
	public String index(Model model) {
		model.addAttribute("users", userService.findAll());
		return "index";
	}
}
