package com.example.runrace.controller;

import com.example.runrace.model.Runner;
import com.example.runrace.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    @Autowired
    private RunnerRepository runnerRepository;

    @GetMapping
    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

    @PostMapping
    public Runner addRunner(@RequestBody Runner runner) {
        return runnerRepository.save(runner);
    }

    @GetMapping("/{id}")
    public Runner getRunnerById(@PathVariable int id) {
        return runnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Runner not found with id " + id));
    }
}
