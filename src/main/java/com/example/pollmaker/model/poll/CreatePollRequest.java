package com.example.pollmaker.model.poll;

import com.example.pollmaker.domain.Option;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePollRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private List<Option> options;
}
