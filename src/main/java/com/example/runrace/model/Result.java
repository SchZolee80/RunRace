package com.example.runrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity // JPA entitás jelölése
public class Result {

    @Id // Elsődleges kulcs jelölése
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Az ID automatikus generálása az adatbázis által
    private int id;

    @ManyToOne // Kapcsolat jelölése a Runner entitással
    @NotNull(message = "A futó nem lehet üres")
    private Runner runner;

    @ManyToOne // Kapcsolat jelölése a Race entitással
    @NotNull(message = "A verseny nem lehet üres")
    private Race race;

    @Min(value = 1, message = "Az időnek legalább 1 percnek kell lennie")
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
