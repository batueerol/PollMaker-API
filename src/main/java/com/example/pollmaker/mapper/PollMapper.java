package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;


import static com.example.pollmaker.utils.Util.isNull;


@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PollMapper {
    //public abstract Poll CreatePollRequestToPoll(CreatePollRequest createPollRequest);

    private final OptionMapper optionMapper;
    public Poll CreatePollRequestToPoll(CreatePollRequest createPollRequest){

        if(isNull(createPollRequest)){
            return null;
        }

        Poll poll = Poll.builder()
                .title(createPollRequest.getTitle())
                .options(optionMapper.StringToOption(createPollRequest.getOptions()))
                .ownerName("admin")
                .build();

        return poll;
    }
    public PollDTO PollToPollDto(Poll poll){
        if(isNull(poll)){
            return null;
        }

        PollDTO pollDTO = PollDTO.builder()
                .title(poll.getTitle())
                .options(optionMapper.optionToOptionDTO(poll.getOptions()))
                .ownerName("admin")
                .build();

        return pollDTO;
    }


}
