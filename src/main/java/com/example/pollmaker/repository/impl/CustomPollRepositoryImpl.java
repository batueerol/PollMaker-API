package com.example.pollmaker.repository.impl;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.model.poll.VoteRequest;
import com.example.pollmaker.repository.CustomPollRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CustomPollRepositoryImpl implements CustomPollRepository {
    private final MongoOperations mongoOperations;
    private final MongoTemplate mongoTemplate;

    @Override
    public Poll updatePoll(String pollId, Poll poll) {
        //Update Block
        Query query = Query.query(Criteria.where("_id").is(pollId));
        Update update = new Update().set("title", poll.getTitle()).set("options", poll.getOptions());
        mongoOperations.updateFirst(query, update, Poll.class);

        return mongoTemplate.findOne(query, Poll.class);
    }

    @Override
    public Poll voteOne(String pollId, VoteRequest voteRequest) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("_id").is(pollId),
                Criteria.where("options").elemMatch(Criteria.where("_id").is(voteRequest.getOptionId()))); // elemMatch controls the object in array.

        query.addCriteria(criteria);

        Update update = new Update();
        update.inc("options.$.voteCount", 1); // $ Acts as a placeholder to update the first element that matches the query condition.

        mongoOperations.updateFirst(query, update, Poll.class);

        return mongoTemplate.findOne(query, Poll.class);
    }
}
