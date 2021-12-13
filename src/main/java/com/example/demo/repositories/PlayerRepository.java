package com.example.demo.repositories;


import com.example.demo.model.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository  extends ReactiveMongoRepository<Player, String> {
}
