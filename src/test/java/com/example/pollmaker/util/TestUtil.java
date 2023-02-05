package com.example.pollmaker.util;

import com.example.pollmaker.model.poll.CreatePollRequest;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static CreatePollRequest getCreatePollRequest(){
        List<String> options = new ArrayList<>();
        options.add("TestOption1");

        return CreatePollRequest.builder()
                .title("Test Title")
                .options(options)
                .build();
    }
}
