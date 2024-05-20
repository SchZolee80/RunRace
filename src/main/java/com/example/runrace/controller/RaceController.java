package com.example.runrace.controller;

import com.example.runrace.model.Race;
import com.example.runrace.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @PostMapping
    public Race addRace(@RequestBody Race race) {
        return raceRepository.save(race);
    }

    @GetMapping("/{id}")
    public Race getRaceById(@PathVariable int id) {
        return raceRepository.findById(id).orElseThrow(() -> new RuntimeException("Race not found with id " + id));
    }
}
