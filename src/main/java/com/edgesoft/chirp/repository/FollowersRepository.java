package com.edgesoft.chirp.repository;

import com.edgesoft.chirp.entity.Follower;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface FollowersRepository extends MongoRepository<Follower, String> {
    List<Follower> findAllByMyId(UUID myId);
}
