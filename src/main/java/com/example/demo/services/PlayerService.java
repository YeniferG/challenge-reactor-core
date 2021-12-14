package com.example.demo.services;

import com.example.demo.CsvUtilFile;
import com.example.demo.model.NationalityRanking;
import com.example.demo.model.Player;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static org.springframework.core.OrderComparator.sort;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;


    public List<Player> getPlayersFunctional(){
        System.out.println(CsvUtilFile.getPlayers().size());
        //return CsvUtilFile.getPlayers();
        return null;
    }

    public Flux<Player> getPlayersReactive(){

        return playerRepository.findAll()
                .buffer(100)
                .flatMap(players -> Flux.fromStream(players.parallelStream()));
    }

    public Flux<Player> filterByAgeGreaterThan34AndClub(String club) {

        return getPlayersReactive()
                .buffer(100)
                .flatMap(players -> Flux.fromStream(players.parallelStream()))
                .filter(jugador -> Objects.nonNull(jugador.getClub()))
                .filter(jugador -> Objects.nonNull(jugador.getAge()))
                .filter(player -> {
                    player.getClub().toUpperCase(Locale.ROOT);
                    return player.getAge() >= 34 && player.getClub().equals(club);
                });
    }

    public void checkNationalitiesAndRanking(){
        System.out.println("Entro");
        playerRepository.findAll()
                .groupBy(Player::getNational)
                .flatMap(player -> {
                    System.out.println("entro");
                    player.collectList().map(listPlayer -> {
                        var n = new NationalityRanking(player.key(), listPlayer.size());
                        System.out.println(n.getRanking() + "- " + n.getNational());
                        return listPlayer;
                    });
                    return player;
                });
                /*.buffer(100)
                .flatMap(juga -> Flux.fromStream(juga.parallelStream()))
                .groupBy(Player::getNational)
                .flatMap(result -> {
                    System.out.println(result.);
                    return result;
                });*/


    }

    public Flux<List<Player>> getRankingPlayer() {

        return getPlayersReactive()
                .buffer(100)
                .flatMap(juga -> Flux.fromStream(juga.parallelStream()))
                .distinct()
                .groupBy(Player::getNational)
                .flatMap(Flux::collectList)
                .map(lista -> {
                    Collections.sort(lista);
                    return lista;
                })
                .onErrorContinue((e, i) ->
                        System.out.println("error filtrandoListas "+i));
    }



}
