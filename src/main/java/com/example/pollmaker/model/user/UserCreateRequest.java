package com.example.pollmaker.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {

    private String email;
    private String firstname;
    private String lastname;
    private String password;
}
