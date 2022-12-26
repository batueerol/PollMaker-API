package com.example.pollmaker.repository;

import com.example.pollmaker.domain.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PollRepository extends MongoRepository<Poll, String> {

}
