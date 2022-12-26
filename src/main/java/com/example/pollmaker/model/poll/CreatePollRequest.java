package com.example.pollmaker.model.poll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePollRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private List<String> options;
}
