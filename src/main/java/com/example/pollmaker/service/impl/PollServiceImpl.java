package com.example.pollmaker.service.impl;


import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.mapper.PollMapper;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.model.poll.VoteRequest;
import com.example.pollmaker.repository.CustomPollRepository;
import com.example.pollmaker.repository.PollRepository;
import com.example.pollmaker.service.PollService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {

    private final PollMapper pollMapper;
    private final CustomPollRepository customPollRepository;
    private final PollRepository pollRepository;


    @Override
    public PollDTO createPoll(CreatePollRequest createPollRequest) {
        Poll poll = pollMapper.createPollRequestToPoll(createPollRequest);
        poll = pollRepository.insert(poll);

        return pollMapper.pollToPollDto(poll);
    }

    @Override
    public PollDTO updatePoll(String pollId, CreatePollRequest createPollRequest) {

        Poll poll = pollMapper.createPollRequestToPoll(createPollRequest);

        return pollMapper.pollToPollDto(customPollRepository.updatePoll(pollId, poll));
    }

    public PollDTO vote(String pollId, VoteRequest voteRequest){
        Poll poll = customPollRepository.voteOne(pollId, voteRequest);

        return pollMapper.pollToPollDto(poll);
    }

    @Override
    public Page<PollDTO> getPolls(Pageable pageable) {
        Page<Poll> polls = pollRepository.findAll(pageable); //pagination

        List<PollDTO> pollDTOs = new ArrayList<>();

        polls.stream().forEach(x -> pollDTOs.add(pollMapper.pollToPollDto(x)));

        return new PageImpl<>(pollDTOs, polls.getPageable(), polls.getTotalElements());
    }

    @Override
    public PollDTO getOnePoll(String pollId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow();

        return pollMapper.pollToPollDto(poll);
    }

}

