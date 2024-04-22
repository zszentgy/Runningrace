package com.runningrace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.runningrace.model.Runner;
import com.runningrace.repository.RunnerRepository;

@RestController
@RequestMapping("/api")
public class RunnerController {
    @Autowired
    private RunnerRepository runnerRepository;

    // GET: List all runners
    @GetMapping("/getRunners")
    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

}
