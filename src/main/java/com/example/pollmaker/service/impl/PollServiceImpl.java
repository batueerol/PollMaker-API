package com.example.pollmaker.service.impl;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.mapper.PollMapper;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.repository.PollRepository;
import com.example.pollmaker.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {


    private final PollMapper pollMapper;

    private final PollRepository pollRepository;

    @Override
    public PollDTO createPoll(CreatePollRequest createPollRequest) {
        Poll poll = pollMapper.CreatePollRequestToPoll(createPollRequest);
        poll = pollRepository.save(poll);

        return pollMapper.PollToCreatePollDto(poll);
    }

    @Override
    public List<PollDTO> getPolls() {
        List<Poll> polls = pollRepository.findAll();

        List<PollDTO> pollDTOS = new ArrayList<>();

        for (Poll poll: polls) {
           pollDTOS.add(pollMapper.PollToCreatePollDto(poll));
        }
        return pollDTOS;
    }
}
