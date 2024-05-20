package com.example.runrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // JPA entitás jelölése
public class Runner {

    @Id // Elsődleges kulcs jelölése
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Az ID automatikus generálása az adatbázis által
    private int id;
    private String name;
    private int age;
    private String gender;

    // Alapértelmezett konstruktor, szükséges a JPA számára
    public Runner() {}

    // Paraméterezett konstruktor a könnyebb példányosításhoz
    public Runner(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getter és setter metódusok az osztályváltozók eléréséhez és módosításához
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
