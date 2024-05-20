package com.example.runrace.controller;

import com.example.runrace.model.Result;
import com.example.runrace.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @PostMapping
    public Result addResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }

    @GetMapping("/{id}")
    public Result getResultById(@PathVariable int id) {
        return resultRepository.findById(id).orElseThrow(() -> new RuntimeException("Result not found with id " + id));
    }
}
