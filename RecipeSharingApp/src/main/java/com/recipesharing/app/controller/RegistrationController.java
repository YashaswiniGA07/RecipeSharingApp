package com.recipesharing.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipesharing.app.dto.UserRegistrationDTO;
import com.recipesharing.app.service.UserService;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

	 private UserService userService;

	    public RegistrationController(UserService userService) {
	        super();
	        this.userService = userService;
	    }

	    @ModelAttribute("user")
	    public UserRegistrationDTO userRegistrationDto() {
	        return new UserRegistrationDTO();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "register";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute("user") 
	              UserRegistrationDTO registrationDto) {
	        userService.save(registrationDto);
	        return "redirect:/login";
	    }
}