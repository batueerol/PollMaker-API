package com.example.pollmaker.service;

import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;

public interface PollService {
    public PollDTO createPoll(CreatePollRequest createPollRequest);
}
