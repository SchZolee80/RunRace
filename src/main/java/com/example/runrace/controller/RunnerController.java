package com.example.runrace.controller;

import com.example.runrace.model.Runner;
import com.example.runrace.service.RunnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    @Autowired
    private RunnerService runnerService;

    /**
     * Összes futó lekérdezése.
     * @return A futók listája.
     */
    @GetMapping
    public List<Runner> getAllRunners() {
        return runnerService.getAllRunners();
    }

    /**
     * Új futó hozzáadása.
     * @param runner A hozzáadandó futó.
     * @return A hozzáadott futó.
     */
    @PostMapping
    public Runner addRunner(@Valid @RequestBody Runner runner) {
        return runnerService.addRunner(runner);
    }

    /**
     * Több futó hozzáadása egyszerre.
     * @param runners A hozzáadandó futók listája.
     * @return A hozzáadott futók listája.
     */
    @PostMapping("/bulk")
    public List<Runner> addRunners(@Valid @RequestBody List<Runner> runners) {
        return runnerService.addRunners(runners);
    }

    /**
     * Futó lekérdezése azonosító alapján.
     * @param id A futó azonosítója.
     * @return A futó, ha megtalálható.
     * @throws RuntimeException Ha a futó nem található.
     */
    @GetMapping("/{id}")
    public Runner getRunnerById(@PathVariable int id) {
        return runnerService.getRunnerById(id);
    }
}
