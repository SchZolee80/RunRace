package com.example.runrace.controller;

import com.example.runrace.model.Race;
import com.example.runrace.model.Result;
import com.example.runrace.service.RaceService;
import com.example.runrace.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RaceViewController {

    @Autowired
    private RaceService raceService;

    @Autowired
    private ResultService resultService;

    /**
     * Versenyek listázása.
     * @param model A model az adatok átadásához.
     * @return A versenyek listájának megjelenítése.
     */
    @GetMapping("/races")
    public String listRaces(Model model) {
        List<Race> races = raceService.getAllRaces();
        model.addAttribute("races", races);
        return "list-races";
    }

    /**
     * Új verseny formjának megjelenítése.
     * @param model A model az adatok átadásához.
     * @return Az új verseny formjának megjelenítése.
     */
    @GetMapping("/races/add")
    public String showAddRaceForm(Model model) {
        model.addAttribute("race", new Race());
        return "add-race";
    }

    /**
     * Új verseny hozzáadása.
     * @param race A hozzáadandó verseny.
     * @return Átirányítás a versenyek listájára.
     */
    @PostMapping("/races/add")
    public String addRace(@ModelAttribute Race race) {
        raceService.addRace(race);
        return "redirect:/races";
    }

    /**
     * Verseny részleteinek megjelenítése.
     * @param id A verseny azonosítója.
     * @param model A model az adatok átadásához.
     * @return A verseny részleteinek megjelenítése.
     */
    @GetMapping("/races/{id}")
    public String showRaceDetails(@PathVariable int id, Model model) {
        Race race = raceService.getRaceById(id);
        List<Result> results = resultService.getResultsByRaceId(id);
        model.addAttribute("race", race);
        model.addAttribute("results", results);
        return "race-details";
    }
}
