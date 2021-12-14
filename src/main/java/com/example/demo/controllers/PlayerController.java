package com.example.demo.controllers;

import com.example.demo.model.Player;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/players-reactive")
    public Flux<Player> getPlayersReactive(){

        return playerService.getPlayersReactive()
                .buffer(100)
                .flatMap(player -> Flux.fromStream(player.parallelStream()));
    }

    @GetMapping("/players-functional")
    public List<Player> getPlayersFunctional(){return playerService.getPlayersFunctional();}

    @GetMapping("/filter/{club}")
    public Flux<Player> getPlayerAgeMore34(@PathVariable("club") String club){
        return playerService.filterByAgeGreaterThan34AndClub(club);
    }

    @GetMapping("/nationality")
    public Flux<List<Player>> checkNationality(){
        return playerService.getRankingPlayer();
    }

}
