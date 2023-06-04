package com.example.pollmaker.model.poll;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePollRequest {

    @NonNull
    private String title;

    @NonNull
    private List<String> options;
}
