package com.recipesharing.app.config;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.recipesharing.app.dto.UserRegistrationDTO;
import com.recipesharing.app.repository.UserRepository;
import com.recipesharing.app.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	        Authentication authentication) throws IOException, ServletException {

	    String redirectUrl = "/dashboard"; // Default redirection URL

	    // Check if the authentication principal is an OAuth2 user
	    if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
	        DefaultOAuth2User userDetails = (DefaultOAuth2User) authentication.getPrincipal();
	        String username = userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login") + "@gmail.com";
	        
	        // Check if the user exists in the repository, and if not, save the user
	        if (userRepo.findByEmail(username) == null) {
	            UserRegistrationDTO user = new UserRegistrationDTO();
	            user.setEmail_id(username);
	            user.setName(userDetails.getAttribute("email") != null ? userDetails.getAttribute("email") : userDetails.getAttribute("login"));
	            user.setPassword("Dummy"); // Consider using a more secure way to generate passwords
	            user.setRole("USER");
	            userService.save(user);
	        }
	    }

	    // Perform redirection using DefaultRedirectStrategy
	    new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}