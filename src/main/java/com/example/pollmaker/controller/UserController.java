package com.example.pollmaker.controller;


import com.example.pollmaker.model.dto.AuthenticationResponse;
import com.example.pollmaker.model.dto.UserDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.model.user.AuthenticationRequest;
import com.example.pollmaker.model.user.UserCreateRequest;
import com.example.pollmaker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserCreateRequest userCreateRequest){
        return ResponseEntity.ok(userService.createUser(userCreateRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(userService.authenticate(authenticationRequest));
    }
}
