package com.example.pollmaker.domain;


import org.springframework.data.annotation.Id;

public class Option {
    @Id
    private int id;
    String value;
    int voteCount;
}
