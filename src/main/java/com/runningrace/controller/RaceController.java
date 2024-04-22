package com.runningrace.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.runningrace.model.Race;
import com.runningrace.model.Result;
import com.runningrace.repository.RaceRepository;
import com.runningrace.repository.ResultRepository;

@RestController
@RequestMapping("/api")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private ResultRepository resultRepository;

    // További API végpontok ...

    // GET: Retrieve all runners for a race sorted by time results in ascending order
    @GetMapping("/getRaceRunners/{id}")
    public ResponseEntity<List<Result>> getRaceRunners(@PathVariable Long id) {

        Optional<Race> race = raceRepository.findById(id);
        if (!race.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Result> results = resultRepository.findByRaceIdOrderByTimeResultAsc(id);
        return ResponseEntity.ok(results);
    }

}
