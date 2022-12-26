package com.example.pollmaker.model.dto;

import com.example.pollmaker.domain.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollDTO {

    private String title;
    private List<Option> options;
    private String ownerName;
}
