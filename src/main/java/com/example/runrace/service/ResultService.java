package com.example.runrace.service;

import com.example.runrace.model.Result;
import com.example.runrace.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    /**
     * Összes eredmény lekérdezése.
     * @return Az eredmények listája.
     */
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    /**
     * Új eredmény hozzáadása.
     * @param result A hozzáadandó eredmény.
     * @return A hozzáadott eredmény.
     */
    public Result addResult(Result result) {
        return resultRepository.save(result);
    }

    /**
     * Több eredmény hozzáadása egyszerre.
     * @param results A hozzáadandó eredmények listája.
     * @return A hozzáadott eredmények listája.
     */
    public List<Result> addResults(List<Result> results) {
        return resultRepository.saveAll(results);
    }

    /**
     * Eredmény lekérdezése azonosító alapján.
     * @param id Az eredmény azonosítója.
     * @return Az eredmény, ha megtalálható.
     * @throws RuntimeException Ha az eredmény nem található.
     */
    public Result getResultById(int id) {
        return resultRepository.findById(id).orElseThrow(() -> new RuntimeException("Result not found with id " + id));
    }

    /**
     * Átlagos futási idő lekérdezése adott versenyre.
     * @param raceId A verseny azonosítója.
     * @return Az átlagos futási idő.
     */
    public double getAverageTime(int raceId) {
        List<Result> results = resultRepository.findByRaceId(raceId);
        return results.stream().mapToInt(Result::getTime).average().orElse(0.0);
    }

    /**
     * Eredmények lekérdezése adott versenyre.
     * @param raceId A verseny azonosítója.
     * @return Az eredmények listája.
     */
    public List<Result> getResultsByRaceId(int raceId) {
        return resultRepository.findByRaceIdOrderByTimeAsc(raceId);
    }
}
