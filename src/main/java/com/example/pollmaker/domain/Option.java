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
    private ObjectId id = new ObjectId();
    String value;
    int voteCount;
}
