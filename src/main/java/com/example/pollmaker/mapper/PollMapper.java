package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PollMapper {
    public abstract Poll CreatePollRequestToPoll(CreatePollRequest createPollRequest);
    public abstract PollDTO PollToCreatePollDto(Poll poll);
}
