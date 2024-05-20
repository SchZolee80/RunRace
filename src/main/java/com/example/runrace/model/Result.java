package com.example.runrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity // JPA entitás jelölése
public class Result {

    @Id // Elsődleges kulcs jelölése
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Az ID automatikus generálása az adatbázis által
    private int id;

    @ManyToOne // Kapcsolat jelölése a Runner entitással
    private Runner runner;

    @ManyToOne // Kapcsolat jelölése a Race entitással
    private Race race;

    private int time; // Az időeredmény percben

    // Alapértelmezett konstruktor, szükséges a JPA számára
    public Result() {}

    // Paraméterezett konstruktor a könnyebb példányosításhoz
    public Result(Runner runner, Race race, int time) {
        this.runner = runner;
        this.race = race;
        this.time = time;
    }

    // Getter és Setter metódusok az osztályváltozók eléréséhez és módosításához
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
