package com.example.pollmaker.model.poll;


import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    @NonNull
    String optionId;
}
