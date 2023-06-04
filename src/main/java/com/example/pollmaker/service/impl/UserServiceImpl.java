package com.example.pollmaker.service.impl;

import com.example.pollmaker.domain.User;
import com.example.pollmaker.exception.user.UserAlreadyExistsException;
import com.example.pollmaker.mapper.UserMapper;
import com.example.pollmaker.model.dto.AuthenticationResponse;
import com.example.pollmaker.model.user.AuthenticationRequest;
import com.example.pollmaker.model.user.UserCreateRequest;
import com.example.pollmaker.repository.UserRepository;
import com.example.pollmaker.service.JwtService;
import com.example.pollmaker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;



    @Override
    public AuthenticationResponse createUser(UserCreateRequest userCreateRequest) throws UserAlreadyExistsException {
        if(isAccountExists(userCreateRequest.getEmail())){
            throw new UserAlreadyExistsException("User is already created with given info.");
        }

        User user = userMapper.userCreateRequestToUser(userCreateRequest);
        userRepository.insert(user);
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();

        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();

    }

    public boolean isAccountExists(String email){
        boolean isAccountExist = userRepository.findByEmail(email).isEmpty();
        return !isAccountExist;
    }
}
