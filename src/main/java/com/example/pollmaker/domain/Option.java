package com.example.pollmaker.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Option {
    @Builder.Default
    private String id = new ObjectId().toString();
    String value;
    int voteCount;
}
