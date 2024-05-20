package com.example.runrace.service;

import com.example.runrace.model.Race;
import com.example.runrace.model.Result;
import com.example.runrace.repository.RaceRepository;
import com.example.runrace.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ResultRepository resultRepository;

    /**
     * Összes verseny lekérdezése.
     * @return A versenyek listája.
     */
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    /**
     * Új verseny hozzáadása.
     * @param race A hozzáadandó verseny.
     * @return A hozzáadott verseny.
     */
    public Race addRace(Race race) {
        return raceRepository.save(race);
    }

    /**
     * Több verseny hozzáadása egyszerre.
     * @param races A hozzáadandó versenyek listája.
     * @return A hozzáadott versenyek listája.
     */
    public List<Race> addRaces(List<Race> races) {
        return raceRepository.saveAll(races);
    }

    /**
     * Verseny lekérdezése azonosító alapján.
     * @param id A verseny azonosítója.
     * @return A verseny, ha megtalálható.
     * @throws RuntimeException Ha a verseny nem található.
     */
    public Race getRaceById(int id) {
        return raceRepository.findById(id).orElseThrow(() -> new RuntimeException("Race not found with id " + id));
    }

    /**
     * Versenyzők és eredményeik lekérdezése adott versenyre.
     * @param id A verseny azonosítója.
     * @return A versenyzők és eredményeik listája.
     */
    public List<Result> getRaceRunners(int id) {
        return resultRepository.findByRaceIdOrderByTimeAsc(id);
    }

    /**
     * Verseny frissítése.
     * @param updatedRace A frissítendő verseny.
     * @return A frissített verseny.
     * @throws RuntimeException Ha a verseny nem található.
     */
    public Race updateRace(Race updatedRace) {
        Race race = raceRepository.findById(updatedRace.getId())
                .orElseThrow(() -> new RuntimeException("Race not found with id " + updatedRace.getId()));
        race.setName(updatedRace.getName());
        race.setDistance(updatedRace.getDistance());
        return raceRepository.save(race);
    }
}
