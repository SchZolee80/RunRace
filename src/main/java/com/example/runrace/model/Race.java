package com.example.runrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GeneratorType;

@Entity // JPA entitás jelölése
public class Race {
    @Id // Elsődleges kulcs jelölése
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Az ID automatikus generálása az adatbázis által

    private int id; // Azonosító -auto generálás
    private String name; //A verseny neve
    private double distance; // A verseny távja

    // Alapértelmezett konstruktor, szükséges a JPA számára
    public Race() {}

    // Paraméterezett konstruktor a könnyebb példányosításhoz
    public Race(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
