package com.example.runrace.controller;

import com.example.runrace.model.Race;
import com.example.runrace.model.Result;
import com.example.runrace.service.RaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    @Autowired
    private RaceService raceService;

    /**
     * Összes verseny lekérdezése.
     * @return A versenyek listája.
     */
    @GetMapping
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }

    /**
     * Új verseny hozzáadása.
     * @param race A hozzáadandó verseny.
     * @return A hozzáadott verseny.
     */
    @PostMapping
    public Race addRace(@Valid @RequestBody Race race) {
        return raceService.addRace(race);
    }

    /**
     * Több verseny hozzáadása egyszerre.
     * @param races A hozzáadandó versenyek listája.
     * @return A hozzáadott versenyek listája.
     */
    @PostMapping("/bulk")
    public List<Race> addRaces(@Valid @RequestBody List<Race> races) {
        return raceService.addRaces(races);
    }

    /**
     * Verseny lekérdezése azonosító alapján.
     * @param id A verseny azonosítója.
     * @return A verseny, ha megtalálható.
     * @throws RuntimeException Ha a verseny nem található.
     */
    @GetMapping("/{id}")
    public Race getRaceById(@PathVariable int id) {
        return raceService.getRaceById(id);
    }

    /**
     * Versenyzők és eredményeik lekérdezése adott versenyre.
     * @param id A verseny azonosítója.
     * @return A versenyzők és eredményeik listája.
     */
    @GetMapping("/getRaceRunners/{id}")
    public List<Result> getRaceRunners(@PathVariable int id) {
        return raceService.getRaceRunners(id);
    }

    /**
     * Verseny frissítése.
     * @param updatedRace A frissítendő verseny.
     * @return A frissített verseny.
     * @throws RuntimeException Ha a verseny nem található.
     */
    @PutMapping("/updateRace")
    public Race updateRace(@Valid @RequestBody Race updatedRace) {
        return raceService.updateRace(updatedRace);
    }
}
