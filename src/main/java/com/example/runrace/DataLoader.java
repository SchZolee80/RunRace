package com.example.runrace;

import com.example.runrace.model.Race;
import com.example.runrace.model.Result;
import com.example.runrace.model.Runner;
import com.example.runrace.repository.RaceRepository;
import com.example.runrace.repository.ResultRepository;
import com.example.runrace.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RunnerRepository runnerRepository;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public void run(String... args) throws Exception {
        // Futók létrehozása
        Runner runner1 = new Runner("Kovács István", 25, "Male");
        Runner runner2 = new Runner("Nagy Éva", 28, "Female");
        Runner runner3 = new Runner("Tóth Gábor", 30, "Male");
        Runner runner4 = new Runner("Szabó Anna", 22, "Female");
        Runner runner5 = new Runner("Kiss Péter", 27, "Male");
        Runner runner6 = new Runner("Molnár Katalin", 26, "Female");
        Runner runner7 = new Runner("Farkas László", 24, "Male");
        Runner runner8 = new Runner("Varga Mária", 29, "Female");
        Runner runner9 = new Runner("Bognár János", 23, "Male");
        Runner runner10 = new Runner("Simon Zsuzsanna", 31, "Female");

        List<Runner> runners = Arrays.asList(runner1, runner2, runner3, runner4, runner5, runner6, runner7, runner8, runner9, runner10);
        runnerRepository.saveAll(runners);

        // Versenyek létrehozása
        Race race1 = new Race("Tavaszi Maraton", 42.195);
        Race race2 = new Race("Nyári Sprint", 5.0);
        Race race3 = new Race("Őszi Félmaraton", 21.0975);
        Race race4 = new Race("Téli Futás", 10.0);
        Race race5 = new Race("Hegyi Kihívás", 15.0);

        List<Race> races = Arrays.asList(race1, race2, race3, race4, race5);
        raceRepository.saveAll(races);

        // Eredmények létrehozása
        Result result1 = new Result(runner1, race1, 240);
        Result result2 = new Result(runner2, race1, 245);
        Result result3 = new Result(runner3, race1, 250);
        Result result4 = new Result(runner4, race2, 20);
        Result result5 = new Result(runner5, race2, 22);
        Result result6 = new Result(runner6, race2, 18);
        Result result7 = new Result(runner7, race3, 95);
        Result result8 = new Result(runner8, race3, 90);
        Result result9 = new Result(runner9, race3, 85);
        Result result10 = new Result(runner10, race4, 40);
        Result result11 = new Result(runner1, race4, 42);
        Result result12 = new Result(runner2, race4, 44);
        Result result13 = new Result(runner3, race5, 65);
        Result result14 = new Result(runner4, race5, 60);
        Result result15 = new Result(runner5, race5, 70);

        List<Result> results = Arrays.asList(result1, result2, result3, result4, result5, result6, result7, result8, result9, result10, result11, result12, result13, result14, result15);
        resultRepository.saveAll(results);
    }
}
