package com.example.demo.services;

import com.example.demo.CsvUtilFile;
import com.example.demo.model.Player;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;


    public List<Player> getPlayersFunctional(){
        return CsvUtilFile.getPlayers();
    }

    public Flux<Player> getPlayersReactive(){
        return playerRepository.findAll();
    }

}
