package com.example.pollmaker.model.dto;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PollDTO {

    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String title;
    private List<OptionDTO> options;
    private String ownerName;
}
