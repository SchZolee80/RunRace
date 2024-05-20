package com.example.runrace.repository;

import com.example.runrace.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository<Runner, Integer> {
}
