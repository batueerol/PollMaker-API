package com.example.pollmaker.service;

import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.model.poll.VoteRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PollService {
    PollDTO createPoll(CreatePollRequest createPollRequest);
    PollDTO updatePoll(String pollId, CreatePollRequest createPollRequest);
    PollDTO vote(String pollId, VoteRequest voteRequest);
    Page<PollDTO> getPolls(Pageable pageable);
    PollDTO getOnePoll(String pollId);
}
