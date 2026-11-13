package com.edgesoft.chirp.repository;

import com.edgesoft.chirp.entity.Followee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface FolloweesRepository extends MongoRepository<Followee, String> {
    List<Followee> findAllByMyId(UUID myId);

    void deleteByMyIdAndFolloweeId(UUID myId, UUID followeeId);
}
