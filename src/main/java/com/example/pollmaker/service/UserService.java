package com.example.pollmaker.service;

import com.example.pollmaker.domain.User;
import com.example.pollmaker.model.dto.AuthenticationResponse;
import com.example.pollmaker.model.dto.UserDTO;
import com.example.pollmaker.model.user.AuthenticationRequest;
import com.example.pollmaker.model.user.UserCreateRequest;


public interface UserService {

    AuthenticationResponse createUser(UserCreateRequest userCreateRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
