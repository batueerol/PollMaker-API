package com.example.pollmaker.service.impl;

import com.example.pollmaker.domain.Option;
import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.mapper.PollMapper;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.model.poll.VoteRequest;
import com.example.pollmaker.repository.PollRepository;
import com.example.pollmaker.service.PollService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {


    private final PollMapper pollMapper;

    private final MongoOperations mongoOperations;
    private final PollRepository pollRepository;

    private final MongoTemplate mongoTemplate;

    @Override
    public PollDTO createPoll(CreatePollRequest createPollRequest) {
        Poll poll = pollMapper.CreatePollRequestToPoll(createPollRequest);
        poll = pollRepository.save(poll);

        return pollMapper.PollToPollDto(poll);
    }

    @Override
    public PollDTO updatePoll(String pollId, CreatePollRequest createPollRequest) {

        Poll poll = pollMapper.CreatePollRequestToPoll(createPollRequest);

        //Update Block
        Query query = Query.query(Criteria.where("_id").is(pollId));
        Update update = new Update().set("title", poll.getTitle()).set("options", poll.getOptions());
        mongoOperations.updateFirst(query, update, Poll.class);

        poll = mongoTemplate.findOne(query, Poll.class);

        return pollMapper.PollToPollDto(poll);
    }

    public PollDTO vote(String pollId, VoteRequest voteRequest){
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("_id").is(pollId),
                Criteria.where("options").elemMatch(Criteria.where("_id").is(voteRequest.getOptionId()))); // elemMatch controls the object in array.

        query.addCriteria(criteria);

        Update update = new Update();
        update.inc("options.$.voteCount", 1); // $ Acts as a placeholder to update the first element that matches the query condition.

        mongoOperations.updateFirst(query, update, Poll.class);

        Poll poll = mongoTemplate.findOne(query, Poll.class);

        return pollMapper.PollToPollDto(poll);
    }
    @Override
    public List<PollDTO> getPolls() {
        List<Poll> polls = pollRepository.findAll(); //pagination

        List<PollDTO> pollDTOS = new ArrayList<>();

        for (Poll poll: polls) {
           pollDTOS.add(pollMapper.PollToPollDto(poll));
        }
        return pollDTOS;
    }

}
