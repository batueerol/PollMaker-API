package com.example.pollmaker.service;

import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;

import java.util.List;

public interface PollService {
    public PollDTO createPoll(CreatePollRequest createPollRequest);
    public PollDTO updatePoll(String pollId, CreatePollRequest createPollRequest);
    public List<PollDTO> getPolls();
}
