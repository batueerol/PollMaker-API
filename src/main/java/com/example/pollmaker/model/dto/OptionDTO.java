package com.example.pollmaker.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "OptionDTO'", description = "Option model of Polls for Response")
public class OptionDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    String value;
}
