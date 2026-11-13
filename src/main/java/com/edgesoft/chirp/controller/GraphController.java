package com.edgesoft.chirp.controller;

import com.edgesoft.chirp.entity.Follower;
import com.edgesoft.chirp.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/followers")
public class GraphController {

    @Autowired
    FollowerService followerService;
    // Get and set mapping for followers and followees

    // id, my id, follower id, date created
    @PostMapping
    public ResponseEntity<Follower> setFollower(){
        Follower save_follower = followerService.setFollower(UUID.fromString("60335a19-9697-432b-9ea2-8049bb904d95"), UUID.randomUUID());
        System.out.println(save_follower);
        return ResponseEntity.ok(save_follower);
    }

    @GetMapping
    public ResponseEntity<List<Follower>> getFollowers(UUID myId){
        List<Follower> followers = followerService.getFollowers(myId);
        return ResponseEntity.ok(followers);
    }
}
