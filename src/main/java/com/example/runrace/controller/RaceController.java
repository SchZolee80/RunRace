package com.example.runrace.controller;

import com.example.runrace.model.Race;
import com.example.runrace.model.Result;
import com.example.runrace.repository.RaceRepository;
import com.example.runrace.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @PostMapping
    public Race addRace(@RequestBody Race race) {
        return raceRepository.save(race);
    }

    //Csoportos verseny hozzáadása miatt
    @PostMapping("/bulk")
    public List<Race> addRaces(@RequestBody List<Race> races) {
        return raceRepository.saveAll(races);
    }

    @GetMapping("/{id}")
    public Race getRaceById(@PathVariable int id) {
        return raceRepository.findById(id).orElseThrow(() -> new RuntimeException("Race not found with id " + id));
    }

    // Új végpont hozzáadása az adott verseny összes futójának és időeredményének lekérdezéséhez
    @GetMapping("/getRaceRunners/{id}")
    public List<Result> getRaceRunners(@PathVariable int id) {
        return resultRepository.findByRaceIdOrderByTimeAsc(id);
    }

    @PutMapping("/updateRace")
    public Race updateRace(@RequestBody Race race) {
        return raceRepository.save(race);
    }
}
