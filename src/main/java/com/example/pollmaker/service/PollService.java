package com.example.pollmaker.service;

import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.model.poll.VoteRequest;

import java.util.List;

public interface PollService {
    public PollDTO createPoll(CreatePollRequest createPollRequest);
    public PollDTO updatePoll(String pollId, CreatePollRequest createPollRequest);
    public PollDTO vote(String pollId, VoteRequest voteRequest);
    public List<PollDTO> getPolls();
}
