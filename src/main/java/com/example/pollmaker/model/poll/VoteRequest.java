package com.example.pollmaker.model.poll;


import lombok.*;
import org.bson.types.ObjectId;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    @NonNull
    ObjectId optionId;
}
