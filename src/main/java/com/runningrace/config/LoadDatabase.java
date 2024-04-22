package com.runningrace.config;

import com.runningrace.model.Runner;
import com.runningrace.model.Race;
import com.runningrace.model.Result;
import com.runningrace.repository.RunnerRepository;
import com.runningrace.repository.RaceRepository;
import com.runningrace.repository.ResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(RunnerRepository runnerRepository, RaceRepository raceRepository, ResultRepository resultRepository) {
        return args -> {
            // Creating runners
            Runner runner1 = runnerRepository.save(new Runner("John Doe", 30, "Male"));
            Runner runner2 = runnerRepository.save(new Runner("Jane Smith", 25, "Female"));
            Runner runner3 = runnerRepository.save(new Runner("Alice Johnson", 28, "Female"));
            Runner runner4 = runnerRepository.save(new Runner("Bob Brown", 32, "Male"));

            // Creating races
            Race race1 = raceRepository.save(new Race("City Marathon", 42.195));
            Race race2 = raceRepository.save(new Race("Park Run", 5.0));

            // Creating results
            resultRepository.save(new Result(runner1, race1, 240));
            resultRepository.save(new Result(runner2, race1, 230));
            resultRepository.save(new Result(runner3, race1, 250));
            resultRepository.save(new Result(runner4, race1, 220));
            resultRepository.save(new Result(runner1, race2, 21));
            resultRepository.save(new Result(runner2, race2, 20));
        };
    }
}
