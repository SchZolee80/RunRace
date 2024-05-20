package com.example.runrace.controller;

import com.example.runrace.model.Result;
import com.example.runrace.service.ResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    /**
     * Összes eredmény lekérdezése.
     * @return Az eredmények listája.
     */
    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    /**
     * Új eredmény hozzáadása.
     * @param result A hozzáadandó eredmény.
     * @return A hozzáadott eredmény.
     */
    @PostMapping
    public Result addResult(@Valid @RequestBody Result result) {
        return resultService.addResult(result);
    }

    /**
     * Több eredmény hozzáadása egyszerre.
     * @param results A hozzáadandó eredmények listája.
     * @return A hozzáadott eredmények listája.
     */
    @PostMapping("/bulk")
    public List<Result> addResults(@Valid @RequestBody List<Result> results) {
        return resultService.addResults(results);
    }

    /**
     * Eredmény lekérdezése azonosító alapján.
     * @param id Az eredmény azonosítója.
     * @return Az eredmény, ha megtalálható.
     * @throws RuntimeException Ha az eredmény nem található.
     */
    @GetMapping("/{id}")
    public Result getResultById(@PathVariable int id) {
        return resultService.getResultById(id);
    }

    /**
     * Átlagos futási idő lekérdezése adott versenyre.
     * @param raceId A verseny azonosítója.
     * @return Az átlagos futási idő.
     */
    @GetMapping("/getAverageTime/{raceId}")
    public double getAverageTime(@PathVariable int raceId) {
        return resultService.getAverageTime(raceId);
    }
}
