package com.example.runrace.service;

import com.example.runrace.model.Runner;
import com.example.runrace.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

    @Autowired
    private RunnerRepository runnerRepository;

    //Összes futó lekérdezése, @return A futók listája.
    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

    //Új futó hozzáadása, @param runner A hozzáadandó futó, @return A hozzáadott futó.
    public Runner addRunner(Runner runner) {
        return runnerRepository.save(runner);
    }

    /**
     * Futó lekérdezése azonosító alapján.
     * @param id A futó azonosítója.
     * @return A futó, ha megtalálható.
     * @throws RuntimeException Ha a futó nem található.
     */
    public Runner getRunnerById(int id) {
        return runnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Runner not found with id " + id));
    }

    /**
     * Több futó hozzáadása egyszerre.
     * @param runners A hozzáadandó futók listája.
     * @return A hozzáadott futók listája.
     */
    public List<Runner> addRunners(List<Runner> runners) {
        return runnerRepository.saveAll(runners);
    }
}
