package com.recipesharing.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.recipesharing.app.service.UserService;

import jakarta.servlet.http.HttpServletRequest;



@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Autowired
	private  UserService userDetailsService;
	
	@Autowired
	AuthenticationSuccessHandler successHandler;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    RequestMatcher staticResourcesMatcher = new OrRequestMatcher(
	        new AntPathRequestMatcher("/css/**"),
	        new AntPathRequestMatcher("/js/**"),
	        new AntPathRequestMatcher("/images/**"),
	        new AntPathRequestMatcher("/webjars/**")
	    );
	    
	    RequestMatcher recipeMatcher = new RequestMatcher() {
	        private AntPathMatcher antPathMatcher = new AntPathMatcher();

	        @Override
	        public boolean matches(HttpServletRequest request) {
	            return antPathMatcher.match("/recipe", request.getServletPath());
	        }
	    };
	    
	    http.authorizeHttpRequests(authorizeRequests ->
	        authorizeRequests
	            .requestMatchers(staticResourcesMatcher, new AntPathRequestMatcher("/login"), new AntPathRequestMatcher("/registration")).permitAll()
	            .requestMatchers(recipeMatcher).permitAll()
	            .anyRequest().authenticated()
	    )
	    .oauth2Login(oauth2Login ->
	        oauth2Login
	            .loginPage("/oauth2/authorization/google")
	            .successHandler(successHandler)
	    )
	    .formLogin(formLogin ->
	        formLogin
	            .loginPage("/login")
	            .successHandler(successHandler)
	    );
	    return http.build();
	}



	

}
