package com.example.pollmaker.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.bson.types.ObjectId;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    @NonNull
    String value;
}
