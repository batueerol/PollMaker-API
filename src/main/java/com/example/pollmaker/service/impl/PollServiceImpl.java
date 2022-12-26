package com.example.pollmaker.service.impl;

import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.service.PollService;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {
    @Override
    public PollDTO createPoll(CreatePollRequest createPollRequest) {
        return null;
    }
}
