package com.edgesoft.chirp.controller;

import com.edgesoft.chirp.entity.Followee;
import com.edgesoft.chirp.entity.Follower;
import com.edgesoft.chirp.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class GraphController {

    @Autowired
    GraphService graphService;
    // Get and set mapping for followers and followees

    // id, my id, follower id, date created
    @PostMapping("/followers")
    public ResponseEntity<Follower> follow(@RequestParam String myId, @RequestParam String followeeId){
        Follower save_follower = graphService.follow(UUID.fromString(myId), UUID.fromString(followeeId));
        return ResponseEntity.ok(save_follower);
    }

    @GetMapping("/followers")
    public ResponseEntity<List<Follower>> getFollowers(@RequestParam String myId){
        List<Follower> followers = graphService.getFollowers(UUID.fromString(myId));
        return ResponseEntity.ok(followers);
    }

    @DeleteMapping("/followers")
    public ResponseEntity<Follower> unfollow(@RequestParam String myId, @RequestParam String followeeId){
        Follower follower = graphService.unfollow(UUID.fromString(myId), UUID.fromString(followeeId));
        return ResponseEntity.ok(follower);
    }

    @GetMapping("/followees")
    public ResponseEntity<List<Followee>> getFollowees(@RequestParam String myId){
        List<Followee> followees = graphService.getFollowees(UUID.fromString(myId));
        return ResponseEntity.ok(followees);
    }
}
