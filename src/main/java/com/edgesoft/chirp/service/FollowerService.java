package com.edgesoft.chirp.service;

import com.edgesoft.chirp.entity.Follower;
import com.edgesoft.chirp.repository.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class FollowerService {
    @Autowired
    private FollowersRepository followersRepository;

    //setfollower
    public Follower setFollower(UUID myId, UUID followerId){
        Follower follower = Follower.builder()
                .myId(myId)
                .followerId(followerId)
                .followedAt(Instant.now())
                .build();
        return followersRepository.save(follower);
    }

    //getfollowers
    public List<Follower> getFollowers(UUID myId){
        return followersRepository.findAll();
    }

    //removefollower
}
