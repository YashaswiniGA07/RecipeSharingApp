package com.recipesharing.application.service;

import com.recipesharing.application.dto.SignUpDTO;
import com.recipesharing.application.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignUpDTO signupDTO);
}