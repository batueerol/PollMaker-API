package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.domain.User;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import static com.example.pollmaker.utils.Util.isNull;


@Component
@AllArgsConstructor
public class PollMapper {
    //public abstract Poll CreatePollRequestToPoll(CreatePollRequest createPollRequest);

    private final OptionMapper optionMapper;

    //logger
    public Poll createPollRequestToPoll(CreatePollRequest createPollRequest){
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = user.getFirstName() + " " + user.getLastName();
        if(isNull(createPollRequest)){
            return null;
        }

        return Poll.builder()
                .title(createPollRequest.getTitle())
                .options(optionMapper.stringToOption(createPollRequest.getOptions()))
                .ownerName(username)
                .build();

    }
    public PollDTO pollToPollDto(Poll poll){
        if(isNull(poll)){
            return null;
        }

        return PollDTO.builder()
                .title(poll.getTitle())
                .options(optionMapper.optionToOptionDTO(poll.getOptions()))
                .ownerName(poll.getOwnerName())
                .build();

    }


}
