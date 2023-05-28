package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.domain.Role;
import com.example.pollmaker.domain.User;
import com.example.pollmaker.model.dto.UserDTO;
import com.example.pollmaker.model.user.UserCreateRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.example.pollmaker.utils.Util.isNull;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    public User userCreateRequestToUser(UserCreateRequest userCreateRequest){
        if(isNull(userCreateRequest)){
            return null;
        }

        return User.builder()
                .email(userCreateRequest.getEmail())
                .firstName(userCreateRequest.getFirstname())
                .lastName(userCreateRequest.getLastname())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .role(Role.USER)
                .build();
    }


    /*public UserDTO userToUserDTO(User user){
        if(isNull(user)){
            return null;
        }

        return UserDTO.builder()
                    .userId(user.getUserId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .build();
    }*/
}
