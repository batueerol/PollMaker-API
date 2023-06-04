package com.example.pollmaker.repository;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.model.poll.VoteRequest;

public interface CustomPollRepository {

    Poll updatePoll(String pollId, Poll poll);
    Poll voteOne(String pollId, VoteRequest voteRequest);
}
