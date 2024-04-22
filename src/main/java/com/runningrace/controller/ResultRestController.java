package com.runningrace.controller;

import com.runningrace.model.Result;
import com.runningrace.model.Runner;
import com.runningrace.dto.ResultDTO;
import com.runningrace.model.Race;
import com.runningrace.repository.ResultRepository;
import com.runningrace.repository.RunnerRepository;
import com.runningrace.repository.RaceRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResultRestController {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private RunnerRepository runnerRepository;
    @Autowired
    private RaceRepository raceRepository;

    // POST: Add a new result
    @PostMapping("/addResult")
    public ResponseEntity<?> addResult(@RequestBody ResultDTO resultDTO) {

        Optional<Runner> runner = runnerRepository.findById(resultDTO.getRunnerId());
        Optional<Race> race = raceRepository.findById(resultDTO.getRaceId());
        if (!runner.isPresent() || !race.isPresent()) {
            return ResponseEntity.badRequest().body("Invalid runner or race ID");
        }

        // Check if a result already exists for this runner and race
        if (resultRepository.findByRunnerIdAndRaceId(resultDTO.getRunnerId(), resultDTO.getRaceId()).isPresent()) {
            return ResponseEntity.badRequest().body("Result already exists for this runner and race");
        }

        Result result = new Result();
        result.setRunner(runner.get());
        result.setRace(race.get());
        result.setTimeResult(resultDTO.getTimeResult());
        resultRepository.save(result);

        return ResponseEntity.ok(result);

    }
}
