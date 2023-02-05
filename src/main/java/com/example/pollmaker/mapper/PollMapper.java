package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;


import static com.example.pollmaker.utils.Util.isNull;


@Component
@AllArgsConstructor
public class PollMapper {
    //public abstract Poll CreatePollRequestToPoll(CreatePollRequest createPollRequest);

    private final OptionMapper optionMapper;

    //logger
    public Poll CreatePollRequestToPoll(CreatePollRequest createPollRequest){

        if(isNull(createPollRequest)){
            return null;
        }

        return Poll.builder()
                .title(createPollRequest.getTitle())
                .options(optionMapper.StringToOption(createPollRequest.getOptions()))
                .ownerName("admin")
                .build();

    }
    public PollDTO PollToPollDto(Poll poll){
        if(isNull(poll)){
            return null;
        }

        return PollDTO.builder()
                .title(poll.getTitle())
                .options(optionMapper.optionToOptionDTO(poll.getOptions()))
                .ownerName("admin")
                .build();

    }


}
