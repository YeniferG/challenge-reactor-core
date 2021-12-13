package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "players")
public class Player {

    @Id
    public String id;

    public String codePlayer;
    public String name;
    public Integer age;
    public String icon;
    public String national;
    public Integer winners;
    public Integer games;
    public String club;

    public Player(){

    }

    public Player(String codePlayer, String name, Integer age, String icon, String national, Integer winners, Integer games, String club) {
        this.codePlayer = codePlayer;
        this.name = name;
        this.age = age;
        this.icon = icon;
        this.national = national;
        this.winners = winners;
        this.games = games;
        this.club = club;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodePlayer() {
        return codePlayer;
    }

    public void setCodePlayer(String codePlayer) {
        this.codePlayer = codePlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public Integer getWinners() {
        return winners;
    }

    public void setWinners(Integer winners) {
        this.winners = winners;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}


