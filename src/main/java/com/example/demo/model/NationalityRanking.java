package com.example.demo.model;

public class NationalityRanking {

    public String national;
    public Integer ranking;

    public NationalityRanking() {
    }

    public NationalityRanking(String national, Integer ranking) {
        this.ranking = ranking;
        this.national = national;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }
}
