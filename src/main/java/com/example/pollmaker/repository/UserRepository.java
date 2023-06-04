package com.example.pollmaker.repository;

import com.example.pollmaker.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Override
    <S extends User> S insert(S entity);

    Optional<User> findByEmail(String email);
}
