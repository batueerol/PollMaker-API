package com.example.pollmaker.model.poll;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "CreatePollRequest", description = "Poll model for create")

public class CreatePollRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private List<String> options;
}
