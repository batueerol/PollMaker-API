package com.example.pollmaker.model.poll;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePollRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private List<String> options;
}
