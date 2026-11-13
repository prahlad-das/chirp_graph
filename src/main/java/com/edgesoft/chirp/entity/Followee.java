package com.edgesoft.chirp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "followee")
@CompoundIndex(name = "myid-followee", def = "{'myId': 1, 'followeeId': 1}", unique = true)
public class Followee {
    @Id
    String id;

    @Indexed
    UUID myId;
    UUID followeeId;
    Instant followedAt;
}
