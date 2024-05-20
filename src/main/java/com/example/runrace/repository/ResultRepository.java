package com.example.runrace.repository;

import com.example.runrace.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    // Új metódus hozzáadása az adott verseny eredményeinek lekérdezéséhez idő szerinti növekvő sorrendben
    List<Result> findByRaceIdOrderByTimeAsc(int raceId);
}
