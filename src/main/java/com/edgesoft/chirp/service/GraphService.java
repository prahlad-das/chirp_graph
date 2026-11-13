package com.edgesoft.chirp.service;

import com.edgesoft.chirp.entity.Followee;
import com.edgesoft.chirp.entity.Follower;
import com.edgesoft.chirp.repository.FolloweesRepository;
import com.edgesoft.chirp.repository.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class GraphService {
    @Autowired
    private FollowersRepository followersRepository;

    @Autowired
    private FolloweesRepository followeesRepository;

    //setfollower
    @Transactional
    public Follower follow(UUID myId, UUID followeeId){
        Follower follower = Follower.builder()
                .myId(followeeId)
                .followerId(myId)
                .followedAt(Instant.now())
                .build();
        Followee followee = Followee.builder()
                .myId(myId)
                .followeeId(followeeId)
                .followedAt(Instant.now())
                .build();
        followeesRepository.save(followee);
        return followersRepository.save(follower);
    }

    //getfollowers
    public List<Follower> getFollowers(UUID myId){
        return followersRepository.findAllByMyId(myId);
    }

    //removefollower
    @Transactional
    public Follower unfollow(UUID myId, UUID followeeId){
        followersRepository.deleteByMyIdAndFollowerId(followeeId, myId);
        followeesRepository.deleteByMyIdAndFolloweeId(myId, followeeId);
        return Follower.builder().build();
    }

    public List<Followee> getFollowees(UUID myId){
        return followeesRepository.findAllByMyId(myId);

    }
}
